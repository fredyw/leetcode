// https://leetcode.com/problems/maximum-distance-between-unequal-words-in-array-i/description/
pub fn max_distance(words: Vec<String>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        max_distance(vec![
            "leetcode".to_string(),
            "leetcode".to_string(),
            "codeforces".to_string()
        ])
    ); // 3
    println!(
        "{}",
        max_distance(vec![
            "a".to_string(),
            "b".to_string(),
            "c".to_string(),
            "a".to_string(),
            "a".to_string()
        ])
    ); // 4
    println!(
        "{}",
        max_distance(vec!["z".to_string(), "z".to_string(), "z".to_string()])
    ); // 0
}
