use std::collections::{HashSet, VecDeque};

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
pub fn character_replacement(s: String, k: i32) -> i32 {
    let chars: Vec<char> = s.chars().collect();
    let set: HashSet<char> = s.chars().collect();
    let mut answer = 0;
    for char in set.iter() {
        let mut deque: VecDeque<usize> = VecDeque::new();
        let mut j = 0;
        for i in 0..chars.len() {
            if chars[i] != *char {
                deque.push_back(i);
            }
            let length = if deque.len() as i32 > k {
                j = deque.pop_front().unwrap_or(0) + 1;
                i as i32 - j as i32
            } else {
                i as i32 - j as i32 + 1
            };
            answer = answer.max(length);
        }
    }
    answer
}

fn main() {
    println!("{}", character_replacement("ABAB".to_string(), 2)); // 4
    println!("{}", character_replacement("AABABBA".to_string(), 1)); // 4
    println!("{}", character_replacement("AABAABAAACAB".to_string(), 2)); // 9
    println!("{}", character_replacement("AB".to_string(), 2)); // 2
    println!("{}", character_replacement("AB".to_string(), 1)); // 2
    println!("{}", character_replacement("AABAABAAABAB".to_string(), 2)); // 9
    println!("{}", character_replacement("AAAAA".to_string(), 2)); // 5
}
