use itertools::Itertools;
use std::cmp::Ordering;
use std::collections::{HashMap, VecDeque};

// https://leetcode.com/problems/sort-vowels-by-frequency/description/
pub fn sort_vowels(s: String) -> String {
    let mut vowel_counts: HashMap<char, (i32, usize)> = HashMap::new();
    for (i, c) in s.chars().enumerate() {
        if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
            let (count, _) = vowel_counts.entry(c).or_insert((0, i));
            *count += 1;
        }
    }
    let mut vowel_counts: VecDeque<(char, (i32, usize))> = vowel_counts
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
    let mut char = ' ';
    let mut count = 0;
    for c in s.chars() {
        if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
            if count == 0 {
                let (ch, (cnt, _)) = vowel_counts.pop_front().unwrap();
                char = ch;
                count = cnt;
            }
            answer.push(char);
            count -= 1;
        } else {
            answer.push(c);
        }
    }
    answer
}

fn main() {
    println!("{}", sort_vowels("leetcode".to_string())); // "leetcedo"
    println!("{}", sort_vowels("aeiaaioooa".to_string())); // "aaaaoooiie"
}
