use std::collections::HashMap;

// https://leetcode.com/problems/implement-trie-ii-prefix-tree/description/
struct Trie {
    children: HashMap<char, Trie>,
}

impl Trie {
    fn new() -> Self {
        Self {
            children: HashMap::new(),
        }
    }

    fn insert(&mut self, word: String) {}

    fn count_words_equal_to(&self, word: String) -> i32 {
        todo!()
    }

    fn count_words_starting_with(&self, prefix: String) -> i32 {
        todo!()
    }

    fn erase(&mut self, word: String) {}
}

fn main() {
    let mut trie = Trie::new();
    trie.insert("apple".to_string());
    trie.insert("apple".to_string());
    println!("{}", trie.count_words_equal_to("apple".to_string())); // 2
    println!("{}", trie.count_words_starting_with("app".to_string())); // 2
    trie.erase("apple".to_string());
    println!("{}", trie.count_words_equal_to("apple".to_string())); // 1
    println!("{}", trie.count_words_starting_with("app".to_string())); // 1
    trie.erase("apple".to_string());
    println!("{}", trie.count_words_starting_with("app".to_string())); // 0
}
