use std::collections::HashSet;

// https://leetcode.com/problems/add-bold-tag-in-string/
pub fn add_bold_tag(s: String, words: Vec<String>) -> String {
    let mut answer = String::new();
    let words: HashSet<String> = words.into_iter().collect();
    let mut bold_i = 0;
    let mut bold_j = 0;
    let mut is_bold = false;
    for i in 0..s.len() {
        for j in i + 1..=s.len() {
            let sub = &s[i..j];
            if words.contains(sub) {
                if !is_bold {
                    answer.push_str(&s[bold_j..i]);
                    bold_i = i;
                    bold_j = j;
                    is_bold = true;
                } else {
                    bold_i = bold_i.min(i);
                    bold_j = bold_j.max(j);
                }
            }
        }
        if is_bold && i >= bold_j {
            answer.push_str("<b>");
            answer.push_str(&s[bold_i..bold_j]);
            answer.push_str("</b>");
            is_bold = false;
        }
    }
    if is_bold {
        answer.push_str("<b>");
        answer.push_str(&s[bold_i..bold_j]);
        answer.push_str("</b>");
    }
    answer
}

fn main() {
    println!(
        "{}",
        add_bold_tag(
            "abcxyz123".to_string(),
            vec!["abc".to_string(), "123".to_string()]
        )
    ); // "<b>abc</b>xyz<b>123</b>"
    println!(
        "{}",
        add_bold_tag(
            "aaabbb".to_string(),
            vec!["aa".to_string(), "b".to_string()]
        )
    ); // "<b>aaabbb</b>"
    println!(
        "{}",
        add_bold_tag("aaaaa".to_string(), vec!["aaaa".to_string()])
    ); // "<b>aaaaa</b>"
    println!(
        "{}",
        add_bold_tag(
            "abcxyz123".to_string(),
            vec![
                "abc".to_string(),
                "123".to_string(),
                "abcxyz123".to_string()
            ]
        )
    ); // "<b>abcxyz123</b>"
}
