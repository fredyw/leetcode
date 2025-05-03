// https://leetcode.com/problems/unique-word-abbreviation/
struct ValidWordAbbr {}

impl ValidWordAbbr {
    fn new(dictionary: Vec<String>) -> Self {
        todo!()
    }

    fn is_unique(&self, word: String) -> bool {
        todo!()
    }
}

fn main() {
    let valid_word_abbr = ValidWordAbbr::new(vec![
        "deer".to_string(),
        "door".to_string(),
        "cake".to_string(),
        "card".to_string(),
    ]);
    valid_word_abbr.is_unique("dear".to_string()); // false
    valid_word_abbr.is_unique("cart".to_string()); // true
    valid_word_abbr.is_unique("cane".to_string()); // false
    valid_word_abbr.is_unique("make".to_string()); // true
    valid_word_abbr.is_unique("cake".to_string()); // true
    valid_word_abbr.is_unique("deer".to_string()); // false
}
