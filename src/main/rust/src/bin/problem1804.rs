use std::collections::HashMap;

// https://leetcode.com/problems/implement-trie-ii-prefix-tree/description/
struct Trie {
    children: HashMap<u8, Trie>,
    num_words: i32,
}

impl Trie {
    fn new() -> Self {
        Self {
            children: HashMap::new(),
            num_words: 0,
        }
    }

    fn insert(&mut self, word: String) {
        fn insert(trie: &mut Trie, word: &[u8], i: usize) {
            if i == word.len() {
                trie.num_words += 1;
                return;
            }
            if let Some(child) = trie.children.get_mut(&word[i]) {
                insert(child, word, i + 1);
            } else {
                let mut new_trie = Trie::new();
                insert(&mut new_trie, word, i + 1);
                trie.children.insert(word[i], new_trie);
            }
        }

        insert(self, word.as_bytes(), 0)
    }

    fn count_words_equal_to(&self, word: String) -> i32 {
        fn find(trie: &Trie, word: &[u8], i: usize) -> i32 {
            if i == word.len() {
                return trie.num_words;
            }
            if let Some(child) = trie.children.get(&word[i]) {
                find(child, word, i + 1)
            } else {
                0
            }
        }

        find(self, word.as_bytes(), 0)
    }

    fn count_words_starting_with(&self, prefix: String) -> i32 {
        0
    }

    fn erase(&mut self, word: String) {
        fn erase(trie: &mut Trie, word: &[u8], i: usize) {
            if i == word.len() {
                trie.num_words -= 1;
                return;
            }
            if let Some(child) = trie.children.get_mut(&word[i]) {
                erase(child, word, i + 1);
            }
        }

        erase(self, &word.as_bytes(), 0);
    }
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
