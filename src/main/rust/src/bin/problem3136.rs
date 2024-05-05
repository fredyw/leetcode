// https://leetcode.com/problems/valid-word/
pub fn is_valid(word: String) -> bool {
    if word.len() < 3 {
        return false;
    }
    if word.chars().any(|c| !c.is_ascii_alphanumeric()) {
        return false;
    }
    let mut has_vowel = false;
    let mut has_consonant = false;
    for char in word.to_ascii_lowercase().chars() {
        match char {
            'a' | 'e' | 'i' | 'o' | 'u' => has_vowel = true,
            'b' | 'c' | 'd' | 'f' | 'g' | 'h' | 'j' | 'k' | 'l' | 'm' | 'n' | 'p' | 'q' | 'r'
            | 's' | 't' | 'v' | 'w' | 'x' | 'y' | 'z' => has_consonant = true,
            _ => {}
        }
    }
    has_vowel && has_consonant
}

fn main() {
    println!("{}", is_valid("234Adas".to_string())); // true
    println!("{}", is_valid("b3".to_string())); // false
    println!("{}", is_valid("a3$e".to_string())); // false
    println!("{}", is_valid("AhI".to_string())); // true
    println!("{}", is_valid("UuE6".to_string())); // false
}
