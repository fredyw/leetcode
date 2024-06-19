use std::collections::HashSet;

//https://leetcode.com/problems/count-the-number-of-special-characters-i/description/
pub fn number_of_special_chars(word: String) -> i32 {
    let mut uppercase_chars: HashSet<char> = HashSet::new();
    let mut lowercase_chars: HashSet<char> = HashSet::new();
    for char in word.chars() {
        if char.is_ascii_uppercase() {
            uppercase_chars.insert(char);
        } else {
            lowercase_chars.insert(char);
        }
    }
    let mut answer = 0;
    for char in uppercase_chars.iter() {
        if lowercase_chars.contains(&char.to_lowercase().next().unwrap()) {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", number_of_special_chars("aaAbcBC".to_string())); // 3
    println!("{}", number_of_special_chars("abc".to_string())); // 0
    println!("{}", number_of_special_chars("abBCab".to_string())); // 1
}
