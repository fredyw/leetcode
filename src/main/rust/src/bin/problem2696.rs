use std::collections::VecDeque;

// https://leetcode.com/problems/minimum-string-length-after-removing-substrings/
pub fn min_length(s: String) -> i32 {
    fn is_ab_or_cd(chars: &Vec<char>, deque: &VecDeque<char>, i: usize) -> bool {
        if deque.is_empty() {
            return false;
        }
        let first = deque.back().unwrap();
        let second = chars[i];
        (*first == 'A' && second == 'B') || (*first == 'C' && second == 'D')
    }

    let chars: Vec<char> = s.chars().collect();
    let mut deque: VecDeque<char> = VecDeque::new();
    let mut i = 0;
    while i < chars.len() {
        if is_ab_or_cd(&chars, &deque, i) {
            deque.pop_back();
        } else {
            deque.push_back(chars[i]);
        }
        i += 1;
    }
    deque.len() as i32
}

fn main() {
    println!("{}", min_length("ABFCACDB".to_string())); // 2
    println!("{}", min_length("ACBBD".to_string())); // 5
}
