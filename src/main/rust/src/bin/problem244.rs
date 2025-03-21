use std::collections::HashMap;

// https://leetcode.com/problems/shortest-word-distance-ii/description/
struct WordDistance {
    map: HashMap<String, Vec<i32>>,
}

impl WordDistance {
    fn new(words_dict: Vec<String>) -> Self {
        let mut map: HashMap<String, Vec<i32>> = HashMap::new();
        for (i, word) in words_dict.iter().enumerate() {
            map.entry(word.to_string()).or_insert(vec![]).push(i as i32);
        }
        Self { map }
    }

    fn shortest(&self, word1: String, word2: String) -> i32 {
        let mut answer = i32::MAX;
        let indexes1 = self.map.get(&word1).unwrap();
        let indexes2 = self.map.get(&word2).unwrap();
        let mut i = 0;
        let mut j = 0;
        while i < indexes1.len() && j < indexes2.len() {
            answer = answer.min((indexes1[i] - indexes2[j]).abs());
            if indexes1[i] < indexes2[j] {
                i += 1;
            } else {
                j += 1;
            }
        }
        answer
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
    println!(
        "{}",
        word_distance.shortest("practice".to_string(), "makes".to_string())
    ); // 1
    println!(
        "{}",
        word_distance.shortest("perfect".to_string(), "makes".to_string())
    ); // 1
}
