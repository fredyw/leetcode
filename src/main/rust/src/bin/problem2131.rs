use std::collections::HashMap;

// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
pub fn longest_palindrome(words: Vec<String>) -> i32 {
    let mut map: HashMap<String, i32> = HashMap::new();
    for word in words.into_iter() {
        *map.entry(word).or_insert(0) += 1;
    }
    let mut answer = 0;
    let mut has_odd = false;
    while let Some((word, count)) = map.iter().next() {
        let bytes = word.as_bytes();
        if bytes[0] == bytes[1] {
            if *count % 2 != 0 {
                has_odd = true;
            }
            answer += if *count % 2 == 0 {
                *count * 2
            } else {
                (*count - 1) * 2
            };
            map.remove(&word.clone());
        } else {
            let reversed_word: String = word.chars().rev().collect();
            if let Some(c) = map.get(&reversed_word) {
                answer += count.min(c) * 4;
                map.remove(&word.clone());
                map.remove(&reversed_word);
            } else {
                map.remove(&word.clone());
            }
        }
    }
    if has_odd {
        answer + 2
    } else {
        answer
    }
}

fn main() {
    println!(
        "{}",
        longest_palindrome(vec!["lc".to_string(), "cl".to_string(), "gg".to_string()])
    ); // 6
    println!(
        "{}",
        longest_palindrome(vec![
            "ab".to_string(),
            "ty".to_string(),
            "yt".to_string(),
            "lc".to_string(),
            "cl".to_string(),
            "ab".to_string()
        ])
    ); // 8
    println!(
        "{}",
        longest_palindrome(vec!["cc".to_string(), "ll".to_string(), "xx".to_string()])
    ); // 2
    println!(
        "{}",
        longest_palindrome(vec![
            "lc".to_string(),
            "cl".to_string(),
            "gg".to_string(),
            "gg".to_string(),
            "gg".to_string(),
            "aa".to_string(),
            "aa".to_string()
        ])
    ); // 14
    println!(
        "{}",
        longest_palindrome(vec![
            "lc".to_string(),
            "cl".to_string(),
            "gg".to_string(),
            "gg".to_string(),
            "gg".to_string(),
            "aa".to_string()
        ])
    ); // 10
}
