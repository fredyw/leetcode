use std::collections::HashMap;

// https://leetcode.com/problems/apply-substitutions/
pub fn apply_substitutions(replacements: Vec<Vec<String>>, text: String) -> String {
    fn substitute(s: &str, map: &HashMap<&str, &str>) -> String {
        let mut string = String::new();
        let chars: Vec<char> = s.chars().collect();
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
                string.push_str(&substitute(map.get(s.as_str()).unwrap(), map));
            } else {
                string.push(chars[i]);
            }
            i += 1;
        }
        string
    }

    let mut map: HashMap<&str, &str> = HashMap::new();
    for replacement in replacements.iter() {
        map.insert(&replacement[0], &replacement[1]);
    }
    substitute(&text, &map)
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
