// https://leetcode.com/problems/sort-the-jumbled-numbers/
pub fn sort_jumbled(mapping: Vec<i32>, nums: Vec<i32>) -> Vec<i32> {
    fn pad(s: &str, length: usize) -> String {
        "0".repeat(length) + &s.to_owned()
    }
    let longest = nums.iter().map(|a| a.to_string().len()).max().unwrap();
    let mut sorted_nums: Vec<(i32, String)> = nums
        .iter()
        .map(|a| {
            let chars: Vec<char> = a.to_string().chars().collect();
            let mut s = String::from("");
            for c in chars {
                s.push_str(&mapping[c as usize - '0' as usize].to_string());
            }
            (*a, pad(&s, longest - s.len()))
        })
        .collect();
    sorted_nums.sort_by(|a, b| a.1.cmp(&b.1));
    sorted_nums.iter().map(|a| a.0).collect()
}

fn main() {
    println!(
        "{:?}",
        sort_jumbled(vec![8, 9, 4, 0, 2, 1, 3, 5, 7, 6], vec![991, 338, 38])
    ); // [338,38,991]
    println!(
        "{:?}",
        sort_jumbled(vec![8, 9, 4, 0, 2, 1, 3, 5, 7, 6], vec![991, 38, 338])
    ); // [38,338,991]
    println!(
        "{:?}",
        sort_jumbled(vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9], vec![789, 456, 123])
    ); // [123,456,789]
}
