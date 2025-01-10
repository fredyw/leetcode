// https://leetcode.com/problems/sort-features-by-popularity/description/
pub fn sort_features(features: Vec<String>, responses: Vec<String>) -> Vec<String> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        sort_features(
            vec![
                "cooler".to_string(),
                "lock".to_string(),
                "touch".to_string()
            ],
            vec![
                "i like cooler cooler".to_string(),
                "lock touch cool".to_string(),
                "locker like touch".to_string()
            ]
        )
    ); // ["touch","cooler","lock"]
    println!(
        "{:?}",
        sort_features(
            vec![
                "a".to_string(),
                "aa".to_string(),
                "b".to_string(),
                "c".to_string()
            ],
            vec![
                "a".to_string(),
                "a aa".to_string(),
                "a a a a a".to_string(),
                "b a".to_string()
            ]
        )
    ); // ["a","aa","b","c"]
}
