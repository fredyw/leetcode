use std::collections::HashMap;

// https://leetcode.com/problems/majority-frequency-characters/
pub fn majority_frequency_group(s: String) -> String {
    let mut map: HashMap<char, i32> = HashMap::new();
    for c in s.chars() {
        *map.entry(c).or_insert(0) += 1;
    }
    todo!()
}

fn main() {
    println!("{}", majority_frequency_group("aaabbbccdddde".to_string())); // "ab"
    println!("{}", majority_frequency_group("abcd".to_string())); // "abcd"
    println!("{}", majority_frequency_group("pfpfgi".to_string())); // "fp"
}
