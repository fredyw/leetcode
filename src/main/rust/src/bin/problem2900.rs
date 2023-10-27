// https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/
pub fn get_words_in_longest_subsequence(
    n: i32,
    words: Vec<String>,
    groups: Vec<i32>,
) -> Vec<String> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        get_words_in_longest_subsequence(
            3,
            vec!["e".to_string(), "a".to_string(), "b".to_string()],
            vec![0, 0, 1]
        )
    ); // ["e","b"]
    println!(
        "{:?}",
        get_words_in_longest_subsequence(
            4,
            vec![
                "a".to_string(),
                "b".to_string(),
                "c".to_string(),
                "d".to_string()
            ],
            vec![1, 0, 1, 1]
        )
    ); // ["a","b","c"]
    println!(
        "{:?}",
        get_words_in_longest_subsequence(
            4,
            vec![
                "a".to_string(),
                "b".to_string(),
                "c".to_string(),
                "def".to_string()
            ],
            vec![1, 0, 1, 1]
        )
    ); // ["a","b","c"]
    println!(
        "{:?}",
        get_words_in_longest_subsequence(
            4,
            vec![
                "a".to_string(),
                "b".to_string(),
                "c".to_string(),
                "def".to_string()
            ],
            vec![1, 0, 1, 1]
        )
    ); // ["a","b","c","def"]
}
