use std::collections::{HashMap, HashSet, VecDeque};

// https://leetcode.com/problems/shortest-word-distance-ii/description/
struct WordDistance {
    map: HashMap<String, Vec<String>>,
}

impl WordDistance {
    fn new(words_dict: Vec<String>) -> Self {
        let mut map: HashMap<String, Vec<String>> = HashMap::new();
        let mut i = 0;
        while i < words_dict.len() {
            if i + 1 < words_dict.len() {
                map.entry(words_dict[i].clone())
                    .or_insert(vec![])
                    .push(words_dict[i + 1].clone());
            }
            if i > 0 {
                map.entry(words_dict[i].clone())
                    .or_insert(vec![])
                    .push(words_dict[i - 1].clone());
            }
            i += 1;
        }
        Self { map }
    }

    fn shortest(&self, word1: String, word2: String) -> i32 {
        let mut answer = i32::MAX;
        let mut queue: VecDeque<(&str, i32)> = VecDeque::new();
        let mut visited: HashSet<&str> = HashSet::new();
        queue.push_back((&word1, 0));
        while let Some((front, distance)) = queue.pop_front() {
            if visited.contains(front) {
                continue;
            }
            visited.insert(front);
            if front == &word2 {
                answer = answer.min(distance);
            }
            if let Some(v) = self.map.get(front) {
                for adj in v.iter() {
                    queue.push_back((adj, distance + 1));
                }
            }
        }
        answer
    }
}

fn main() {
    let word_distance = WordDistance::new(vec![
        "practice".to_string(),
        "makes".to_string(),
        "perfect".to_string(),
        "coding".to_string(),
        "makes".to_string(),
    ]);
    println!(
        "{}",
        word_distance.shortest("coding".to_string(), "practice".to_string())
    ); // 3
       // println!(
       //     "{}",
       //     word_distance.shortest("makes".to_string(), "coding".to_string())
       // ); // 1
       // println!(
       //     "{}",
       //     word_distance.shortest("practice".to_string(), "makes".to_string())
       // ); // 1
       // println!(
       //     "{}",
       //     word_distance.shortest("perfect".to_string(), "makes".to_string())
       // ); // 1
}
