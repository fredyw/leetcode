use std::collections::HashMap;

// https://leetcode.com/problems/total-distance-to-type-a-string-using-one-finger/description/
pub fn total_distance(s: String) -> i32 {
    let keyboard = vec![
        vec!['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'],
        vec!['a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'],
        vec!['z', 'x', 'c', 'v', 'b', 'n', 'm'],
    ];
    let mut chars: HashMap<char, (i32, i32)> = HashMap::new();
    for i in 0..keyboard.len() {
        for j in 0..keyboard[i].len() {
            chars.insert(keyboard[i][j], (i as i32, j as i32));
        }
    }
    let mut answer = 0;
    let mut prev_pos = (1, 0);
    for char in s.chars() {
        let cur_pos = chars[&char];
        answer += (prev_pos.0 - cur_pos.0).abs() + (prev_pos.1 - cur_pos.1).abs();
        prev_pos = cur_pos;
    }
    answer
}

fn main() {
    println!("{}", total_distance("hello".to_string())); // 17
    println!("{}", total_distance("a".to_string())); // 0
}
