use std::collections::HashSet;

// https://leetcode.com/problems/password-strength/description/
pub fn password_strength(password: String) -> i32 {
    let mut lowercase_chars: HashSet<char> = HashSet::new();
    let mut uppercase_chars: HashSet<char> = HashSet::new();
    let mut numbers: HashSet<char> = HashSet::new();
    let mut special_chars: HashSet<char> = HashSet::new();
    for char in password.chars() {
        if char.is_lowercase() {
            lowercase_chars.insert(char);
        } else if char.is_uppercase() {
            uppercase_chars.insert(char);
        } else if char.is_digit(10) {
            numbers.insert(char);
        } else {
            special_chars.insert(char);
        }
    }
    ((lowercase_chars.len() * 1)
        + (uppercase_chars.len() * 2)
        + (numbers.len() * 3)
        + (special_chars.len() * 5)) as i32
}

fn main() {
    println!("{}", password_strength("aA1!".to_string())); // 11
    println!("{}", password_strength("bbB11#".to_string())); // 11
}
