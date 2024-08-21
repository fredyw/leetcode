use std::collections::{HashMap, VecDeque};

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
pub fn character_replacement(s: String, k: i32) -> i32 {
    let chars: Vec<char> = s.chars().collect();
    let mut answer = 0;
    let mut deque: VecDeque<usize> = VecDeque::new();
    deque.push_back(0);
    let mut map: HashMap<char, i32> = HashMap::new();
    *map.entry(chars[0]).or_insert(0) += 1;
    for i in 1..chars.len() {
        println!("{i}:");
        if chars[i - 1] != chars[i] {
            deque.push_back(i);
        }
        println!(" deque: {:?}", deque);
        *map.entry(chars[i]).or_insert(0) += 1;
        println!(" map: {:?}", map);
        while map.len() as i32 > k {
            let index = deque.pop_front().unwrap();
            let count = map.get_mut(&chars[index]).unwrap();
            *count -= 1;
            if *count == 0 {
                map.remove(&chars[index]);
            }
        }
        answer = answer.max(i as i32 - *deque.front().unwrap_or(&0) as i32 + 1);
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
}
