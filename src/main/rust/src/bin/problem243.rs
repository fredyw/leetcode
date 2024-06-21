// https://leetcode.com/problems/shortest-word-distance/description/
pub fn shortest_distance(words_dict: Vec<String>, word1: String, word2: String) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        shortest_distance(
            vec![
                "practice".to_string(),
                "makes".to_string(),
                "perfect".to_string(),
                "coding".to_string(),
                "makes".to_string()
            ],
            "coding".to_string(),
            "practice".to_string()
        )
    ); // 3
    println!(
        "{}",
        shortest_distance(
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
}
