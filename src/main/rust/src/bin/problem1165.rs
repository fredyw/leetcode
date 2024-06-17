use std::collections::HashMap;

// https://leetcode.com/problems/single-row-keyboard/description/
pub fn calculate_time(keyboard: String, word: String) -> i32 {
    let keyboard = keyboard.as_bytes();
    let mut map: HashMap<&u8, usize> = HashMap::new();
    for (i, b) in keyboard.iter().enumerate() {
        map.insert(b, i);
    }
    let mut answer: i32 = 0;
    let mut first = true;
    let mut prev: &u8 = &0;
    for b in word.as_bytes() {
        if first {
            first = false;
            answer += *map.get(b).unwrap() as i32;
        } else {
            answer += (*map.get(&prev).unwrap() as i32 - *map.get(b).unwrap() as i32).abs();
        }
        prev = b;
    }
    answer
}

fn main() {
    println!(
        "{}",
        calculate_time("abcdefghijklmnopqrstuvwxyz".to_string(), "cba".to_string())
    ); // 4
    println!(
        "{}",
        calculate_time(
            "pqrstuvwxyzabcdefghijklmno".to_string(),
            "leetcode".to_string()
        )
    ); // 73
}
