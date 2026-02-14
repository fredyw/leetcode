// https://leetcode.com/problems/weighted-word-mapping/
pub fn map_word_weights(words: Vec<String>, weights: Vec<i32>) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        map_word_weights(
            vec!["abcd".to_string(), "def".to_string(), "xyz".to_string()],
            vec![5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2]
        )
    ); // "rij"
    println!(
        "{}",
        map_word_weights(
            vec!["a".to_string(), "b".to_string(), "c".to_string()],
            vec![1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
        )
    ); // "yyy"
    println!(
        "{}",
        map_word_weights(
            vec!["abcd".to_string()],
            vec![7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5]
        )
    ); // "g"
}
