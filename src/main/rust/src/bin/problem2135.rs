use std::collections::HashSet;

// https://leetcode.com/problems/count-words-obtained-after-adding-a-letter/
pub fn word_count(start_words: Vec<String>, target_words: Vec<String>) -> i32 {
    let start_set: HashSet<String> = start_words
        .into_iter()
        .map(|w| {
            let mut chars: Vec<char> = w.chars().collect();
            chars.sort();
            chars.into_iter().collect::<String>()
        })
        .collect();
    let mut answer = 0;
    for target in target_words.into_iter() {
        let mut chars: Vec<char> = target.chars().collect();
        chars.sort();
        for i in 0..chars.len() {
            let mut s: String = (&chars[0..i]).into_iter().collect();
            s.push_str(&(&chars[i + 1..]).into_iter().collect::<String>());
            if start_set.contains(&s) {
                answer += 1;
                break;
            }
        }
    }
    answer
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
