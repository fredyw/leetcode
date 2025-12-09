use std::collections::HashMap;

// https://leetcode.com/problems/maximum-number-of-equal-length-runs/description/
pub fn max_same_length_runs(s: String) -> i32 {
    let bytes = s.as_bytes();
    let mut length = 1;
    let mut map: HashMap<i32, i32> = HashMap::new();
    for i in 0..bytes.len() - 1 {
        if bytes[i] == bytes[i + 1] {
            length += 1;
        } else {
            *map.entry(length).or_insert(0) += 1;
            length = 1;
        }
    }
    *map.entry(length).or_insert(0) += 1;
    map.into_iter().map(|(_, count)| count).max().unwrap()
}

fn main() {
    println!("{}", max_same_length_runs("hello".to_string())); // 3
    println!("{}", max_same_length_runs("aaabaaa".to_string())); // 2
}
