use std::collections::HashMap;

// https://leetcode.com/problems/apply-operations-to-make-string-empty/description/
pub fn last_non_empty_string(s: String) -> String {
    let mut map: HashMap<char, u32> = HashMap::new();
    for c in s.chars().into_iter() {
        *map.entry(c).or_insert(0) += 1;
    }
    let mut max_count = 0;
    for (_, count) in map.iter() {
        max_count = max_count.max(*count);
    }
    let mut answer = String::new();
    // TODO
    answer
}

fn main() {
    println!("{}", last_non_empty_string("aabcbbca".to_string())); // "ba"
    println!("{}", last_non_empty_string("abcd".to_string())); // "abcd"
    println!("{}", last_non_empty_string("abbccc".to_string())); // "c"
}
