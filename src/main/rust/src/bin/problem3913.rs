use itertools::Itertools;
use std::cmp::Ordering;
use std::collections::HashMap;

// https://leetcode.com/problems/sort-vowels-by-frequency/description/
pub fn sort_vowels(s: String) -> String {
    let mut vowel_counts: HashMap<char, (i32, usize)> = HashMap::new();
    for (i, c) in s.chars().enumerate() {
        if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
            let (count, _) = vowel_counts.entry(c).or_insert((0, i));
            *count += 1;
        }
    }
    let vowel_counts: Vec<(char, (i32, usize))> = vowel_counts
        .into_iter()
        .sorted_by(|(_, (c1, i1)), (_, (c2, i2))| {
            let cmp = c2.cmp(c1);
            if cmp == Ordering::Equal {
                i1.cmp(i2)
            } else {
                cmp
            }
        })
        .collect();
    let mut answer = String::new();
    answer
}

fn main() {
    println!("{}", sort_vowels("leetcode".to_string())); // "leetcedo"
    println!("{}", sort_vowels("aeiaaioooa".to_string())); // "aaaaoooiie"
}
