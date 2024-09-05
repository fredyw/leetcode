use std::collections::HashSet;

// https://leetcode.com/problems/longest-word-with-all-prefixes/description/
pub fn longest_word(words: Vec<String>) -> String {
    struct Trie {
        roots: Vec<Node>,
    }

    struct Node {
        value: char,
        children: Vec<Node>,
    }

    impl Node {
        fn new(value: char) -> Self {
            Self {
                value,
                children: vec![],
            }
        }
    }

    impl Trie {
        fn new() -> Self {
            Self { roots: vec![] }
        }

        fn insert(&mut self, chars: Vec<char>) {
            fn insert(chars: &Vec<char>, index: usize, node: &mut Node) {
                let mut new_nodes = vec![];
                for node in node.children.iter_mut() {
                    if node.value == chars[index] {
                        insert(&chars, index + 1, node);
                    } else {
                        let mut root = Node::new(chars[index]);
                        insert(&chars, index + 1, &mut root);
                        new_nodes.push(root);
                    }
                }
                node.children.extend(new_nodes);
            }

            let mut new_nodes = vec![];
            let mut index = 0;
            for node in self.roots.iter_mut() {
                if node.value == chars[index] {
                    insert(&chars, index + 1, node);
                } else {
                    let mut root = Node::new(chars[index]);
                    insert(&chars, index + 1, &mut root);
                    new_nodes.push(root);
                }
            }
            self.roots.extend(new_nodes);
        }

        fn find(&self, chars: Vec<char>, index: usize) {}
    }

    let mut answer = String::new();
    let mut set: HashSet<String> = HashSet::new();
    let mut trie = Trie::new();
    for word in words.iter() {
        set.insert(word.to_string());
        trie.insert(word.chars().collect());
    }
    for word in words.into_iter() {
        let chars: Vec<char> = word.chars().collect();
    }
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
}
