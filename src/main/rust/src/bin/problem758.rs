use std::collections::HashSet;

// https://leetcode.com/problems/bold-words-in-string/description/
pub fn bold_words(words: Vec<String>, s: String) -> String {
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
    answer.push_str(&s[bold_j..]);
    answer
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
    println!(
        "{}",
        bold_words(
            vec!["aaa".to_string(), "aab".to_string(), "bc".to_string()],
            "aaabbcc".to_string()
        )
    ); // "<b>aaabbc</b>c"
}
