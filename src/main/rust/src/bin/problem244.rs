use std::collections::HashMap;

// https://leetcode.com/problems/shortest-word-distance-ii/description/
struct WordDistance {}

impl WordDistance {
    fn new(wordsDict: Vec<String>) -> Self {
        Self {}
    }

    fn shortest(&self, word1: String, word2: String) -> i32 {
        todo!()
    }
}

fn main() {
    let word_distance = WordDistance::new(vec![
        "practice".to_string(),
        "makes".to_string(),
        "perfect".to_string(),
        "coding".to_string(),
        "makes".to_string(),
    ]);
    println!(
        "{}",
        word_distance.shortest("coding".to_string(), "practice".to_string())
    ); // 3
    println!(
        "{}",
        word_distance.shortest("makes".to_string(), "coding".to_string())
    ); // 1
}
