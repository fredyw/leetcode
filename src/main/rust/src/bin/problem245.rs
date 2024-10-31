// https://leetcode.com/problems/shortest-word-distance-iii/
pub fn shortest_word_distance(words_dict: Vec<String>, word1: String, word2: String) -> i32 {
    todo!()
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
}
