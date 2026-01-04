// https://leetcode.com/problems/reverse-string-prefix/description/
pub fn reverse_prefix(s: String, k: i32) -> String {
    format!(
        "{}{}",
        s[0..k as usize].chars().rev().collect::<String>(),
        s[k as usize..s.len()].to_string()
    )
}

fn main() {
    println!("{}", reverse_prefix("abcd".to_string(), 2)); // "bacd"
    println!("{}", reverse_prefix("xyz".to_string(), 3)); // "zyx"
    println!("{}", reverse_prefix("hey".to_string(), 1)); // "hey"
}
