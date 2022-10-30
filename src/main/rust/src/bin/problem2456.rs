// https://leetcode.com/problems/words-within-two-edits-of-dictionary/
pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        two_edit_words(
            vec![
                "word".to_string(),
                "note".to_string(),
                "ants".to_string(),
                "wood".to_string()
            ],
            vec!["wood".to_string(), "joke".to_string(), "moat".to_string()]
        )
    ); // ["word","note","wood"]
    println!(
        "{:?}",
        two_edit_words(vec!["yes".to_string()], vec!["not".to_string()])
    ); // []
}
