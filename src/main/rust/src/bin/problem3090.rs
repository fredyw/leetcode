use std::collections::HashMap;

// https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/
pub fn maximum_length_substring(s: String) -> i32 {
    let mut answer = 0;
    let bytes = s.as_bytes();
    for i in 0..bytes.len() {
        let mut map: HashMap<u8, i32> = HashMap::new();
        let mut length = 0;
        for j in i..bytes.len() {
            *map.entry(bytes[j]).or_insert(0) += 1;
            if let Some(c) = map.get(&bytes[j]) {
                if *c == 3 {
                    break;
                }
            }
            length += 1;
            answer = answer.max(length);
        }
    }
    answer
}

fn main() {
    println!("{}", maximum_length_substring("bcbbbcba".to_string())); // 4
    println!("{}", maximum_length_substring("aaaa".to_string())); // 2
}
