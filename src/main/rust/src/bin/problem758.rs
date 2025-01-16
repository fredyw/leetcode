// https://leetcode.com/problems/bold-words-in-string/description/
pub fn bold_words(words: Vec<String>, s: String) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        bold_words(
            vec!["ab".to_string(), "bc".to_string()],
            "aabcd".to_string()
        )
    ); // "a<b>abc</b>d"
    println!(
        "{}",
        bold_words(
            vec!["ab".to_string(), "cb".to_string()],
            "aabcd".to_string()
        )
    ); // "a<b>ab</b>cd"
}
