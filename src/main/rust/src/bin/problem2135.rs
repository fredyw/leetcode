// https://leetcode.com/problems/count-words-obtained-after-adding-a-letter/
pub fn word_count(start_words: Vec<String>, target_words: Vec<String>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        word_count(
            vec!["ant".to_string(), "act".to_string(), "tack".to_string()],
            vec!["tack".to_string(), "act".to_string(), "acti".to_string()]
        )
    ); // 2
    println!(
        "{}",
        word_count(
            vec!["ab".to_string(), "a".to_string()],
            vec!["abc".to_string(), "abcd".to_string()]
        )
    ); // 1
}
