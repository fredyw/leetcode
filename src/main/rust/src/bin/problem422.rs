// https://leetcode.com/problems/valid-word-square/description/
pub fn valid_word_square(words: Vec<String>) -> bool {
    let words: Vec<&[u8]> = words.iter().map(|w| w.as_bytes()).collect();
    for (i, &word) in words.iter().enumerate() {
        for (j, b) in word.iter().enumerate() {
            if j >= words.len() || i >= words[j].len() {
                return false;
            }
            if *b != words[j][i] {
                return false;
            }
        }
    }
    true
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
    println!(
        "{}",
        valid_word_square(vec![
            "ball".to_string(),
            "asee".to_string(),
            "let".to_string(),
            "lep".to_string()
        ])
    ); // false
}
