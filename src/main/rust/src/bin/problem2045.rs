use std::collections::HashSet;

// https://leetcode.com/problems/optimal-partition-of-string/
pub fn partition_string(s: String) -> i32 {
    let mut answer = 0;
    let mut chars: HashSet<char> = HashSet::new();
    for c in s.chars().into_iter().collect::<Vec<char>>() {
        if chars.contains(&c) {
            answer += 1;
            chars.clear();
        }
        chars.insert(c);
    }
    answer + 1
}

fn main() {
    println!("{}", partition_string("abacaba".to_string())); // 4
    println!("{}", partition_string("ssssss".to_string())); // 6
}
