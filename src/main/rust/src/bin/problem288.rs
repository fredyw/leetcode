use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/unique-word-abbreviation/
struct ValidWordAbbr {
    words: HashSet<String>,
    abbrs: HashMap<String, u32>,
}

impl ValidWordAbbr {
    fn new(dictionary: Vec<String>) -> Self {
        let words: HashSet<String> = dictionary.into_iter().collect();
        let mut abbrs: HashMap<String, u32> = HashMap::new();
        for word in words.iter() {
            *abbrs.entry(abbr(word)).or_insert(0) += 1;
        }
        Self { abbrs, words }
    }

    fn is_unique(&self, word: String) -> bool {
        let abbr = abbr(&word);
        if let Some(count) = self.abbrs.get(&abbr) {
            if *count == 1 {
                self.words.contains(&word)
            } else {
                false
            }
        } else {
            true
        }
    }
}

fn abbr(word: &str) -> String {
    if word.len() <= 2 {
        return word.to_string();
    }
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

    let valid_word_abbr = ValidWordAbbr::new(vec!["a".to_string(), "a".to_string()]);
    println!("{}", valid_word_abbr.is_unique("a".to_string())); // true
}
