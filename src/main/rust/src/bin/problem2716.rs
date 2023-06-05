use std::collections::HashSet;

// https://leetcode.com/problems/minimize-string-length/
pub fn minimized_string_length(s: String) -> i32 {
    s.chars().collect::<HashSet<char>>().len() as i32
}

fn main() {
    println!("{}", minimized_string_length("aaabc".to_string())); // 3
    println!("{}", minimized_string_length("cbbd".to_string())); // 3
    println!("{}", minimized_string_length("dddaaa".to_string())); // 2
    println!("{}", minimized_string_length("dddaaadd".to_string())); // 2
}
