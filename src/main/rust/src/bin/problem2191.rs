// https://leetcode.com/problems/sort-the-jumbled-numbers/
pub fn sort_jumbled(mapping: Vec<i32>, nums: Vec<i32>) -> Vec<i32> {
    fn pad(s: &str, length: usize) -> String {
        "0".repeat(length) + &s.to_owned()
    }
    let mut sorted_nums = nums.clone();
    let longest = nums.iter().map(|a| a.to_string().len()).max().unwrap();
    sorted_nums.sort_by(|a, b| {
        let a: Vec<char> = a.to_string().chars().collect();
        let mut s1 = String::from("");
        for c in a {
            s1.push_str(&mapping[c as usize - '0' as usize].to_string());
        }
        let b: Vec<char> = b.to_string().chars().collect();
        let mut s2 = String::from("");
        for c in b {
            s2.push_str(&mapping[c as usize - '0' as usize].to_string());
        }
        let s1 = pad(&s1, longest - s1.len());
        let s2 = pad(&s2, longest - s2.len());
        s1.cmp(&s2)
    });
    sorted_nums
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
