use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/unique-word-abbreviation/
struct ValidWordAbbr {
    words: HashSet<String>,
    abbrs: HashMap<String, u32>,
}

impl ValidWordAbbr {
    fn new(dictionary: Vec<String>) -> Self {
        let mut abbrs: HashMap<String, u32> = HashMap::new();
        for word in dictionary.iter() {
            *abbrs.entry(abbr(word)).or_insert(0) += 1;
        }
        let words = dictionary.into_iter().collect();
        Self { abbrs, words }
    }

    fn is_unique(&self, word: String) -> bool {
        if !self.words.contains(&word) {
            return true;
        }
        if let Some(count) = self.abbrs.get(&abbr(&word)) {
            if *count > 1 {
                return false;
            }
        } else {
            return true;
        }
        false
    }
}

fn abbr(word: &str) -> String {
    format!(
        "{}{}{}",
        &word[0..1],
        word.len() - 2,
        &word[word.len() - 1..]
    )
}

fn main() {
    let valid_word_abbr = ValidWordAbbr::new(vec![
        "deer".to_string(),
        "door".to_string(),
        "cake".to_string(),
        "card".to_string(),
    ]);
    println!("{}", valid_word_abbr.is_unique("dear".to_string())); // false
    println!("{}", valid_word_abbr.is_unique("cart".to_string())); // true
    println!("{}", valid_word_abbr.is_unique("cane".to_string())); // false
    println!("{}", valid_word_abbr.is_unique("make".to_string())); // true
    println!("{}", valid_word_abbr.is_unique("cake".to_string())); // true
    println!("{}", valid_word_abbr.is_unique("deer".to_string())); // false
}
