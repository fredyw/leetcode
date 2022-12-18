// https://leetcode.com/problems/count-pairs-of-similar-strings/
pub fn similar_pairs(words: Vec<String>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        similar_pairs(vec![
            "aba".to_string(),
            "aabb".to_string(),
            "abcd".to_string(),
            "bac".to_string(),
            "aabc".to_string()
        ])
    ); // 2
    println!(
        "{}",
        similar_pairs(vec!["aabb".to_string(), "ab".to_string(), "ba".to_string()])
    ); // 3
    println!(
        "{}",
        similar_pairs(vec![
            "nba".to_string(),
            "cba".to_string(),
            "dba".to_string()
        ])
    ); // 0
}
