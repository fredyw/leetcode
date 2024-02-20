use std::collections::HashMap;

// https://leetcode.com/problems/apply-operations-to-make-string-empty/description/
pub fn last_non_empty_string(s: String) -> String {
    let mut map: HashMap<char, u32> = HashMap::new();
    let mut max_count = 0;
    for c in s.chars().into_iter() {
        let count = map.entry(c).or_insert(0);
        *count += 1;
        max_count = max_count.max(*count);
    }
    let mut map: HashMap<char, u32> = map
        .into_iter()
        .filter(|(_, count)| *count == max_count)
        .collect();
    let mut answer = String::new();
    for c in s.chars().rev() {
        if map.contains_key(&c) {
            answer.push(c);
            map.remove(&c);
        }
    }
    answer.chars().rev().collect()
}

fn main() {
    println!("{}", last_non_empty_string("aabcbbca".to_string())); // "ba"
    println!("{}", last_non_empty_string("abcd".to_string())); // "abcd"
    println!("{}", last_non_empty_string("abbccc".to_string())); // "c"
}
