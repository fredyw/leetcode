use std::collections::HashMap;

// https://leetcode.com/problems/number-of-same-end-substrings/description/
pub fn same_end_substring_count(s: String, queries: Vec<Vec<i32>>) -> Vec<i32> {
    let mut answer = vec![];
    for query in queries {
        let sub = &s[query[0] as usize..=query[1] as usize];
        let mut map: HashMap<char, i32> = HashMap::new();
        let mut sum = 0;
        for c in sub.chars() {
            let count = map.entry(c).or_insert(0);
            *count += 1;
            sum += *count;
        }
        answer.push(sum);
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        same_end_substring_count(
            "abcaab".to_string(),
            vec![vec![0, 0], vec![1, 4], vec![2, 5], vec![0, 5]]
        )
    ); // [1,5,5,10]
    println!(
        "{:?}",
        same_end_substring_count("abcd".to_string(), vec![vec![0, 3]])
    ); // [4]
    println!(
        "{:?}",
        same_end_substring_count("aaaabbbccd".to_string(), vec![vec![0, 9]])
    ); // [20]
}
