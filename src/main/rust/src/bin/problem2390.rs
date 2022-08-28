use std::collections::VecDeque;

// https://leetcode.com/problems/removing-stars-from-a-string/
pub fn remove_stars(s: String) -> String {
    let mut deque: VecDeque<char> = VecDeque::new();
    let chars: Vec<char> = s.chars().collect();
    for c in chars.into_iter() {
        if c == '*' {
            deque.pop_back();
        } else {
            deque.push_back(c);
        }
    }
    deque.iter().collect::<String>()
}

fn main() {
    println!("{}", remove_stars("leet**cod*e".to_string())); // "lecoe"
    println!("{}", remove_stars("erase*****".to_string())); // ""
}
