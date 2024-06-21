// https://leetcode.com/problems/shortest-word-distance/description/
pub fn shortest_distance(words_dict: Vec<String>, word1: String, word2: String) -> i32 {
    let mut answer = i32::MAX;
    let mut found_word1 = false;
    let mut found_word2 = false;
    let mut word1_index: i32 = 0;
    let mut word2_index: i32 = 0;
    for (i, s) in words_dict.iter().enumerate() {
        if *s == word1 {
            found_word1 = true;
            word1_index = i as i32;
        } else if *s == word2 {
            found_word2 = true;
            word2_index = i as i32;
        }
        if found_word1 && found_word2 {
            answer = answer.min((word1_index - word2_index).abs());
        }
    }
    answer
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
