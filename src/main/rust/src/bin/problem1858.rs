use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/longest-word-with-all-prefixes/description/
pub fn longest_word(words: Vec<String>) -> String {
    #[derive(Debug)]
    struct Trie {
        roots: HashMap<char, Node>,
    }

    #[derive(Debug)]
    struct Node {
        children: HashMap<char, Node>,
    }

    impl Node {
        fn new() -> Self {
            Self {
                children: HashMap::new(),
            }
        }
    }

    impl Trie {
        fn new() -> Self {
            Self {
                roots: HashMap::new(),
            }
        }

        fn insert(&mut self, chars: Vec<char>) {
            fn insert(chars: &Vec<char>, index: usize, node: &mut Node) {
                if index == chars.len() {
                    return;
                }
                if let Some(child) = node.children.get_mut(&chars[index]) {
                    insert(&chars, index + 1, child);
                } else {
                    let mut child = Node::new();
                    insert(&chars, index + 1, &mut child);
                    node.children.insert(chars[index], child);
                }
            }

            let index = 0;
            if let Some(root) = self.roots.get_mut(&chars[index]) {
                insert(&chars, index + 1, root);
            } else {
                let mut root = Node::new();
                insert(&chars, index + 1, &mut root);
                self.roots.insert(chars[index], root);
            }
        }

        fn longest_word(&self, set: &HashSet<String>, answer: &mut String) {
            fn longest_word(
                node: &Node,
                set: &HashSet<String>,
                prefix: &mut String,
                answer: &mut String,
            ) {
                if set.contains(prefix) {
                    if prefix.len() > answer.len() {
                        *answer = prefix.to_owned();
                    } else if prefix.len() == answer.len() {
                        if prefix.cmp(&answer).is_lt() {
                            *answer = prefix.to_owned();
                        }
                    }
                    for (char, child) in node.children.iter() {
                        prefix.push(*char);
                        longest_word(child, set, prefix, answer);
                        prefix.pop();
                    }
                }
            }

            for (char, root) in self.roots.iter() {
                if set.contains(&char.to_string()) {
                    if answer.is_empty() || char.to_string().cmp(answer).is_lt() {
                        *answer = char.to_string().to_string();
                    }
                    let mut prefix = String::new();
                    prefix.push(*char);
                    longest_word(root, set, &mut prefix, answer);
                }
            }
        }
    }

    let mut set: HashSet<String> = HashSet::new();
    let mut trie = Trie::new();
    for word in words.iter() {
        set.insert(word.to_string());
        trie.insert(word.chars().collect());
    }
    let mut answer = String::new();
    trie.longest_word(&set, &mut answer);
    answer
}

fn main() {
    println!(
        "{}",
        longest_word(vec![
            "k".to_string(),
            "ki".to_string(),
            "kir".to_string(),
            "kira".to_string(),
            "kiran".to_string()
        ])
    ); // "kiran"
    println!(
        "{}",
        longest_word(vec![
            "a".to_string(),
            "banana".to_string(),
            "app".to_string(),
            "appl".to_string(),
            "ap".to_string(),
            "apply".to_string(),
            "apple".to_string()
        ])
    ); // "apple"
    println!(
        "{}",
        longest_word(vec![
            "abc".to_string(),
            "bc".to_string(),
            "ab".to_string(),
            "qwe".to_string()
        ])
    ); // ""
    println!(
        "{}",
        longest_word(vec![
            "ki".to_string(),
            "kir".to_string(),
            "kira".to_string(),
            "kiran".to_string()
        ])
    ); // ""
    println!("{}", longest_word(vec!["a".to_string()])); // "a"
    println!("{}", longest_word(vec!["a".to_string(), "app".to_string()])); // "a"
    println!("{}", longest_word(vec!["a".to_string(), "b".to_string()])); // "a"
    println!(
        "{}",
        longest_word(vec!["b".to_string(), "ab".to_string(), "a".to_string()])
    ); // "ab"
}
