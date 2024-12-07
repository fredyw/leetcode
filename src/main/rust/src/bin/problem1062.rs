use std::collections::HashMap;

// https://leetcode.com/problems/longest-repeating-substring/description/
pub fn longest_repeating_substring(s: String) -> i32 {
    let mut map: HashMap<&str, i32> = HashMap::new();
    for i in 0..s.len() {
        for j in i..s.len() {
            let sub = &s[i..=j];
            if sub.len() == s.len() {
                continue;
            }
            *map.entry(sub).or_insert(0) += 1;
        }
    }
    map.into_iter()
        .filter(|(_, count)| *count > 1)
        .map(|(s, _)| s.len())
        .max()
        .unwrap_or(0) as i32
}

fn main() {
    println!("{}", longest_repeating_substring("abcd".to_string())); // 0
    println!("{}", longest_repeating_substring("abbaba".to_string())); // 2
    println!("{}", longest_repeating_substring("aabcaabdaab".to_string())); // 3
    println!("{}", longest_repeating_substring("aa".to_string())); // 1
    println!("{}", longest_repeating_substring("aaaaa".to_string())); // 4
}
