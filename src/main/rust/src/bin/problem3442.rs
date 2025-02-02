use std::collections::HashMap;

// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/description/
pub fn max_difference(s: String) -> i32 {
    let mut map: HashMap<u8, i32> = HashMap::new();
    for b in s.as_bytes() {
        *map.entry(*b).or_insert(0) += 1;
    }
    let mut max_odd: i32 = 0;
    let mut min_even: i32 = i32::MAX;
    for (_, count) in map.iter() {
        if *count % 2 == 0 {
            min_even = min_even.min(*count);
        } else {
            max_odd = max_odd.max(*count);
        }
    }
    max_odd - min_even
}

fn main() {
    println!("{}", max_difference("aaaaabbc".to_string())); // 3
    println!("{}", max_difference("abcabcab".to_string())); // 1
    println!("{}", max_difference("tzt".to_string())); // -1
}
