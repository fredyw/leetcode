// https://leetcode.com/problems/vowel-consonant-score/description/
pub fn vowel_consonant_score(s: String) -> i32 {
    let mut vowels = 0;
    let mut consonants = 0;
    for c in s.chars() {
        if c.is_ascii_alphabetic() {
            if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
                vowels += 1;
            } else {
                consonants += 1;
            }
        }
    }
    if consonants == 0 {
        0
    } else {
        vowels / consonants
    }
}

fn main() {
    println!("{}", vowel_consonant_score("cooear".to_string())); // 2
    println!("{}", vowel_consonant_score("axeyizou".to_string())); // 1
    println!("{}", vowel_consonant_score("au 123".to_string())); // 0
    println!("{}", vowel_consonant_score("0".to_string())); // 0
    println!("{}", vowel_consonant_score("i3".to_string())); // 0
}
