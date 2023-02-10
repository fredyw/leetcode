use std::collections::HashMap;

// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
pub fn smallest_equivalent_string(s1: String, s2: String, base_str: String) -> String {
    struct UnionFind {
        // Child to parent
        v: HashMap<char, char>,
    }

    impl UnionFind {
        fn new() -> UnionFind {
            UnionFind { v: HashMap::new() }
        }

        fn union(&mut self, a: char, b: char) {
            if self.v.get(&a).is_none() {
                self.v.insert(a, a);
            }
            if self.v.get(&b).is_none() {
                self.v.insert(b, b);
            }
            let root_a = self.find(a).unwrap();
            let root_b = self.find(b).unwrap();
            if root_a > root_b {
                self.v.insert(root_a, root_b);
            } else if root_a < root_b {
                self.v.insert(root_b, root_a);
            }
        }

        fn find(&self, a: char) -> Option<char> {
            let mut child = a;
            while let Some(parent) = self.v.get(&child) {
                if *parent == child {
                    return Some(*parent);
                }
                child = *parent;
            }
            None
        }
    }

    let mut uf = UnionFind::new();
    let s1: Vec<char> = s1.chars().collect();
    let s2: Vec<char> = s2.chars().collect();
    for i in 0..s1.len() {
        let a = s1[i];
        let b = s2[i];
        uf.union(a, b);
    }
    let base_str: Vec<char> = base_str.chars().collect();
    let mut answer = "".to_string();
    for c in base_str.into_iter() {
        match uf.find(c) {
            Some(smallest) => answer.push(smallest),
            None => answer.push(c),
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        smallest_equivalent_string(
            "parker".to_string(),
            "morris".to_string(),
            "parser".to_string()
        )
    ); // "makkek"
    println!(
        "{}",
        smallest_equivalent_string("hello".to_string(), "world".to_string(), "hold".to_string())
    ); // "hdld"
    println!(
        "{}",
        smallest_equivalent_string(
            "leetcode".to_string(),
            "programs".to_string(),
            "sourcecode".to_string()
        )
    ); // "aauaaaaada"
}
