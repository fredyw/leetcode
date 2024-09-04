// https://leetcode.com/problems/longest-word-with-all-prefixes/description/
pub fn longest_word(words: Vec<String>) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        longest_word(vec![
            "k".to_string(),
            "ki".to_string(),
            "kir".to_string(),
            "kira".to_string(),
            "kiran".to_string()
        ])
    ); // "kiran"
    println!(
        "{}",
        longest_word(vec![
            "a".to_string(),
            "banana".to_string(),
            "app".to_string(),
            "appl".to_string(),
            "ap".to_string(),
            "apply".to_string(),
            "apple".to_string()
        ])
    ); // "apple"
    println!(
        "{}",
        longest_word(vec![
            "abc".to_string(),
            "bc".to_string(),
            "ab".to_string(),
            "qwe".to_string()
        ])
    ); // ""
}
