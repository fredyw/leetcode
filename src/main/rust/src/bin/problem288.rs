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
        println!("{:?}", abbrs);
        Self { abbrs, words }
    }

    fn is_unique(&self, word: String) -> bool {
        let abbr = abbr(&word);
        let has_abbr = self.abbrs.contains_key(&abbr);
        let has_words = self.words.contains(&word);
        if !has_abbr || !has_words {
            return true;
        }
        let has_unique_abbr = if let Some(count) = self.abbrs.get(&abbr(&word)) {
            if *count > 1 {
                false
            } else {
                true
            }
        } else {
            true
        };
        has_words && has_unique_abbr
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
