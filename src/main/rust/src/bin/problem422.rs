// https://leetcode.com/problems/valid-word-square/description/
pub fn valid_word_square(words: Vec<String>) -> bool {
    todo!()
}

fn main() {
    println!(
        "{}",
        valid_word_square(vec![
            "abcd".to_string(),
            "bnrt".to_string(),
            "crmy".to_string(),
            "dtye".to_string()
        ])
    ); // true
    println!(
        "{}",
        valid_word_square(vec![
            "abcd".to_string(),
            "bnrt".to_string(),
            "crm".to_string(),
            "dt".to_string()
        ])
    ); // true
    println!(
        "{}",
        valid_word_square(vec![
            "ball".to_string(),
            "area".to_string(),
            "read".to_string(),
            "lady".to_string()
        ])
    ); // false
}
