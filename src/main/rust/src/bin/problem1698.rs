use std::collections::HashSet;

// https://leetcode.com/problems/number-of-distinct-substrings-in-a-string/description/
pub fn count_distinct(s: String) -> i32 {
    let mut set: HashSet<&str> = HashSet::new();
    for i in 0..s.len() {
        for j in i..s.len() {
            let sub = &s[i..=j];
            set.insert(sub);
        }
    }
    set.len() as i32
}

fn main() {
    println!("{}", count_distinct("aabbaba".to_string())); // 21
    println!("{}", count_distinct("abcdefg".to_string())); // 28
}
