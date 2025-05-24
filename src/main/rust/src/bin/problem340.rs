use std::collections::{HashMap, VecDeque};

// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
pub fn length_of_longest_substring_k_distinct(s: String, k: i32) -> i32 {
    let bytes = s.as_bytes();
    let mut map: HashMap<u8, i32> = HashMap::new();
    let mut answer = 0;
    for i in 0..bytes.len() {}
    answer
}

fn main() {
    println!(
        "{}",
        length_of_longest_substring_k_distinct("eceba".to_string(), 2)
    ); // 3
    println!(
        "{}",
        length_of_longest_substring_k_distinct("aa".to_string(), 1)
    ); // 2
}
