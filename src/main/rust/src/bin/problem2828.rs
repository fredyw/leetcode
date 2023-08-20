// https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/
pub fn is_acronym(words: Vec<String>, s: String) -> bool {
    words
        .into_iter()
        .map(|c| *c.chars().collect::<Vec<char>>().get(0).unwrap())
        .collect::<String>()
        == s
}

fn main() {
    println!(
        "{}",
        is_acronym(
            vec![
                "alice".to_string(),
                "bob".to_string(),
                "charlie".to_string()
            ],
            "abc".to_string()
        )
    ); // true
    println!(
        "{}",
        is_acronym(vec!["an".to_string(), "apple".to_string()], "a".to_string())
    ); // false
    println!(
        "{}",
        is_acronym(
            vec![
                "never".to_string(),
                "gonna".to_string(),
                "give".to_string(),
                "up".to_string(),
                "on".to_string(),
                "you".to_string()
            ],
            "ngguoy".to_string()
        )
    ); // true
}
