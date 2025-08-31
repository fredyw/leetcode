use std::collections::HashMap;

// https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/description/
pub fn minimum_deletions(word: String, k: i32) -> i32 {
    let mut freq: HashMap<char, i32> = HashMap::new();
    for char in word.chars() {
        *freq.entry(char).or_insert(0) += 1;
    }
    println!("{:?}", freq);
    0
}

fn main() {
    println!("{}", minimum_deletions("aabcaba".to_string(), 0)); // 3
    println!("{}", minimum_deletions("dabdcbdcdcd".to_string(), 2)); // 2
    println!("{}", minimum_deletions("aaabaaa".to_string(), 2)); // 1
}
