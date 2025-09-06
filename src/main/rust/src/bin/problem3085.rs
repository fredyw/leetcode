use std::collections::HashMap;

// https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/description/
pub fn minimum_deletions(word: String, k: i32) -> i32 {
    let mut freq: HashMap<char, i32> = HashMap::new();
    for char in word.chars() {
        *freq.entry(char).or_insert(0) += 1;
    }
    let mut answer = i32::MAX;
    for (_, target_count) in &freq {
        let mut deletions = 0;
        for (_, current_count) in &freq {
            if target_count > current_count {
                deletions += current_count;
            } else if target_count + k < *current_count {
                deletions += *current_count - *target_count - k;
            }
        }
        answer = answer.min(deletions);
    }
    answer
}

fn main() {
    println!("{}", minimum_deletions("aabcaba".to_string(), 0)); // 3
    println!("{}", minimum_deletions("dabdcbdcdcd".to_string(), 2)); // 2
    println!("{}", minimum_deletions("aaabaaa".to_string(), 2)); // 1
}
