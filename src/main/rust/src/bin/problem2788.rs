// https://leetcode.com/problems/split-strings-by-separator/
pub fn split_words_by_separator(words: Vec<String>, separator: char) -> Vec<String> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        split_words_by_separator(
            vec![
                "one.two.three".to_string(),
                "four.five".to_string(),
                "six".to_string()
            ],
            '.'
        )
    ); // ["one","two","three","four","five","six"]
    println!(
        "{:?}",
        split_words_by_separator(vec!["$easy$".to_string(), "$problem$".to_string()], '$')
    ); // ["easy","problem"]
    println!(
        "{:?}",
        split_words_by_separator(vec!["|||".to_string()], '|')
    ); // []
}
