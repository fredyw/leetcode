use std::collections::HashMap;

// https://leetcode.com/problems/apply-substitutions/
pub fn apply_substitutions(replacements: Vec<Vec<String>>, text: String) -> String {
    let mut map: HashMap<String, String> = HashMap::new();
    for replacement in replacements {
        map.insert(replacement[0].clone(), replacement[1].clone());
    }
    let mut answer = String::new();
    let chars: Vec<char> = text.chars().collect();
    let mut i = 0;
    while i < chars.len() {
        if chars[i] == '%' {
            let mut j = i + 1;
            let mut s = String::new();
            while j < chars.len() && chars[j] != '%' {
                s.push(chars[j]);
                j += 1;
            }
            i = j;
            answer.push_str(map.get(&s).unwrap());
        } else {
            answer.push(chars[i]);
        }
        i += 1;
    }
    answer
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
    println!(
        "{}",
        apply_substitutions(
            vec![
                vec!["C".to_string(), "abc%B%".to_string()],
                vec!["A".to_string(), "bce".to_string()],
                vec!["B".to_string(), "ace".to_string()]
            ],
            "%A%_%B%_%C%".to_string()
        )
    ); // "bce_ace_abcace"
}
