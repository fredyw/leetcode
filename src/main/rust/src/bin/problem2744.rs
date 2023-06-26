use std::collections::HashMap;

// https://leetcode.com/problems/find-maximum-number-of-string-pairs/
pub fn maximum_number_of_string_pairs(words: Vec<String>) -> i32 {
    let mut word_map: HashMap<String, i32> = HashMap::new();
    for word in words.iter() {
        *word_map.entry(word.clone()).or_insert(0) += 1;
    }
    let mut answer = 0;
    for word in words.iter() {
        let reversed_word: String = word.chars().rev().collect();
        if word == &reversed_word {
            continue;
        }
        let count = word_map.get(&reversed_word).unwrap_or(&0);
        if count > &0 {
            answer += 1;
        }
    }
    answer / 2
}

fn main() {
    println!(
        "{}",
        maximum_number_of_string_pairs(vec![
            "cd".to_string(),
            "ac".to_string(),
            "dc".to_string(),
            "ca".to_string(),
            "zz".to_string()
        ])
    ); // 2
    println!(
        "{}",
        maximum_number_of_string_pairs(vec!["ab".to_string(), "ba".to_string(), "cc".to_string()])
    ); // 1
    println!(
        "{}",
        maximum_number_of_string_pairs(vec!["aa".to_string(), "ab".to_string()])
    ); // 0
    println!(
        "{}",
        maximum_number_of_string_pairs(vec![
            "ff".to_string(),
            "tx".to_string(),
            "qr".to_string(),
            "zw".to_string(),
            "wr".to_string(),
            "jr".to_string(),
            "zt".to_string(),
            "jk".to_string(),
            "sq".to_string(),
            "xx".to_string()
        ])
    ); // 0
}
