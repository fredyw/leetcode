use std::collections::HashMap;

// https://leetcode.com/problems/shortest-word-distance-iii/
pub fn shortest_word_distance(words_dict: Vec<String>, word1: String, word2: String) -> i32 {
    let mut map: HashMap<&str, Vec<i32>> = HashMap::new();
    for (i, word) in words_dict.iter().enumerate() {
        map.entry(word).or_insert(vec![]).push(i as i32);
    }
    let mut answer = i32::MAX;
    let mut i = 0;
    let mut j = 0;
    let indexes1 = map.get(word1.as_str()).unwrap();
    let indexes2 = map.get(word2.as_str()).unwrap();
    while i < indexes1.len() && j < indexes2.len() {
        if i == j && words_dict[indexes1[i] as usize] == words_dict[indexes2[j] as usize] {
            i += 1;
            continue;
        }
        answer = answer.min((indexes1[i] - indexes2[j]).abs());
        if indexes1[i] < indexes2[j] {
            i += 1;
        } else {
            j += 1;
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        shortest_word_distance(
            vec![
                "practice".to_string(),
                "makes".to_string(),
                "perfect".to_string(),
                "coding".to_string(),
                "makes".to_string()
            ],
            "makes".to_string(),
            "coding".to_string()
        )
    ); // 1
    println!(
        "{}",
        shortest_word_distance(
            vec![
                "practice".to_string(),
                "makes".to_string(),
                "perfect".to_string(),
                "coding".to_string(),
                "makes".to_string()
            ],
            "makes".to_string(),
            "makes".to_string()
        )
    ); // 3
    println!(
        "{}",
        shortest_word_distance(
            vec!["a".to_string(), "b".to_string(),],
            "a".to_string(),
            "b".to_string()
        )
    ); // 1
}
