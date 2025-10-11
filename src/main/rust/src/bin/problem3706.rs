// https://leetcode.com/problems/maximum-distance-between-unequal-words-in-array-ii/description/
pub fn max_distance(words: Vec<String>) -> i32 {
    let mut answer = 0;
    for (i, word) in words.iter().enumerate() {
        if *word != words[0] {
            answer = answer.max(i as i32 + 1);
        }
        if *word != words[words.len() - 1] {
            answer = answer.max(words.len() as i32 - i as i32);
        }
    }
    answer
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
    println!(
        "{}",
        max_distance(vec![
            "a".to_string(),
            "b".to_string(),
            "c".to_string(),
            "a".to_string(),
            "b".to_string()
        ])
    ); // 5
}
