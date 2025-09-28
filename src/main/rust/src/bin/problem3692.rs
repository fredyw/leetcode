use std::cmp::Ordering;
use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/majority-frequency-characters/
pub fn majority_frequency_group(s: String) -> String {
    let mut freqs: HashMap<char, i32> = HashMap::new();
    for c in s.chars() {
        *freqs.entry(c).or_insert(0) += 1;
    }
    let mut group_size: HashMap<i32, HashSet<char>> = HashMap::new();
    for (char, count) in &freqs {
        group_size
            .entry(*count)
            .or_insert(HashSet::new())
            .insert(*char);
    }
    group_size
        .iter()
        .max_by(|(freq1, set1), (freq2, set2)| {
            let cmp = set1.len().cmp(&set2.len());
            if cmp == Ordering::Equal {
                freq1.cmp(freq2)
            } else {
                cmp
            }
        })
        .unwrap()
        .1
        .iter()
        .collect()
}

fn main() {
    println!("{}", majority_frequency_group("aaabbbccdddde".to_string())); // "ab"
    println!("{}", majority_frequency_group("abcd".to_string())); // "abcd"
    println!("{}", majority_frequency_group("pfpfgi".to_string())); // "fp"
}
