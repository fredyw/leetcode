use std::collections::HashMap;

// https://leetcode.com/problems/permutation-difference-between-two-strings/
pub fn find_permutation_difference(s: String, t: String) -> i32 {
    let mut map: HashMap<char, usize> = HashMap::new();
    for (i, char) in t.chars().enumerate() {
        map.insert(char, i);
    }
    let mut answer = 0;
    for (i, char) in s.chars().enumerate() {
        answer += (*map.get(&char).unwrap() as i32 - i as i32).abs();
    }
    answer
}

fn main() {
    println!(
        "{}",
        find_permutation_difference("abc".to_string(), "bac".to_string())
    ); // 2
    println!(
        "{}",
        find_permutation_difference("abcde".to_string(), "edbac".to_string())
    ); // 12
}
