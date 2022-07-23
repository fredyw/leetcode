use std::collections::HashMap;
use std::hash::Hash;

// https://leetcode.com/problems/best-poker-hand/
pub fn best_hand(ranks: Vec<i32>, suits: Vec<char>) -> String {
    fn build_map_counts<T>(v: &Vec<T>) -> HashMap<T, i32>
    where
        T: Copy + Eq + Hash,
    {
        let mut map_counts: HashMap<T, i32> = HashMap::new();
        v.iter().for_each(|e| {
            match map_counts.get(e) {
                Some(count) => map_counts.insert(*e, count + 1),
                None => map_counts.insert(*e, 1),
            };
        });
        return map_counts;
    }

    let suit_counts = build_map_counts(&suits);
    let rank_counts = build_map_counts(&ranks);
    if suit_counts.len() == 1 {
        "Flush".to_string()
    } else {
        let count = rank_counts.iter().max_by(|a, b| a.1.cmp(b.1)).unwrap().1;
        if *count >= 3 {
            "Three of a Kind".to_string()
        } else if *count == 2 {
            "Pair".to_string()
        } else {
            "High Card".to_string()
        }
    }
}

fn main() {
    println!(
        "{}",
        best_hand(vec![13, 2, 3, 1, 9], vec!['a', 'a', 'a', 'a', 'a'])
    ); // "Flush"
    println!(
        "{}",
        best_hand(vec![4, 4, 2, 4, 4], vec!['d', 'a', 'a', 'b', 'c'])
    ); // "Three of a Kind"
    println!(
        "{}",
        best_hand(vec![10, 10, 2, 12, 9], vec!['a', 'b', 'c', 'a', 'd'])
    ); // "Pair"
}
