// https://leetcode.com/problems/apply-substitutions/
pub fn apply_substitutions(replacements: Vec<Vec<String>>, text: String) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        apply_substitutions(
            vec![
                vec!["A".to_string(), "abc".to_string()],
                vec!["B".to_string(), "def".to_string()]
            ],
            "%A%_%B%".to_string()
        )
    ); // "abc_def"
    println!(
        "{}",
        apply_substitutions(
            vec![
                vec!["A".to_string(), "bce".to_string()],
                vec!["B".to_string(), "ace".to_string()],
                vec!["C".to_string(), "abc%B%".to_string()]
            ],
            "%A%_%B%_%C%".to_string()
        )
    ); // "bce_ace_abcace"
}
