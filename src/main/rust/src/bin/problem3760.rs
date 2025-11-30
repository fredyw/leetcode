use std::collections::HashSet;

// https://leetcode.com/problems/maximum-substrings-with-distinct-start/
pub fn max_distinct(s: String) -> i32 {
    let mut answer = 0;
    let mut set: HashSet<char> = HashSet::new();
    for char in s.chars() {
        if !set.contains(&char) {
            answer += 1;
        }
        set.insert(char);
    }
    answer
}

fn main() {
    println!("{}", max_distinct("abab".to_string())); // 2
    println!("{}", max_distinct("abcd".to_string())); // 4
    println!("{}", max_distinct("aaaa".to_string())); // 1
}
