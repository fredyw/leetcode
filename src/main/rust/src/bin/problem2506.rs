use std::collections::HashSet;

// https://leetcode.com/problems/count-pairs-of-similar-strings/
pub fn similar_pairs(words: Vec<String>) -> i32 {
    let mut v = vec![];
    for word in words.into_iter() {
        let chars: HashSet<char> = word.chars().collect();
        v.push(chars);
    }
    let mut answer = 0;
    for i in 0..v.len() {
        for j in i + 1..v.len() {
            if v[i] == v[j] {
                answer += 1;
            }
        }
    }
    answer
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
