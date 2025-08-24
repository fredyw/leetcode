use std::collections::HashMap;

// https://leetcode.com/problems/filter-characters-by-frequency/description/
pub fn filter_characters(s: String, k: i32) -> String {
    let mut map: HashMap<&u8, i32> = HashMap::new();
    for b in s.as_bytes() {
        *map.entry(b).or_insert(0) += 1;
    }
    let mut answer = String::new();
    for b in s.as_bytes() {
        if map.get(b).unwrap() < &k {
            answer.push(*b as char);
        }
    }
    answer
}

fn main() {
    println!("{}", filter_characters("aadbbcccca".to_string(), 3)); // "dbb"
    println!("{}", filter_characters("xyz".to_string(), 2)); // "xyz"
}
