use std::collections::HashMap;

// https://leetcode.com/problems/minimum-length-of-string-after-operations/description/
pub fn minimum_length(s: String) -> i32 {
    let mut map: HashMap<&u8, i32> = HashMap::new();
    for b in s.as_bytes() {
        *map.entry(b).or_insert(0) += 1;
    }
    let mut answer = s.len() as i32;
    for (_, count) in map.iter() {
        if count % 3 == 0 {
            answer -= count;
        }
    }
    answer
}

fn main() {
    println!("{}", minimum_length("abaacbcbb".to_string())); // 5
    println!("{}", minimum_length("aa".to_string())); // 2
}
