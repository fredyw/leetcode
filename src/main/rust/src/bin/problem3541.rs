use std::collections::HashMap;

// https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description/
pub fn max_freq_sum(s: String) -> i32 {
    let mut vowels: HashMap<char, i32> = HashMap::new();
    let mut consonants: HashMap<char, i32> = HashMap::new();
    for c in s.chars() {
        match c {
            'a' | 'e' | 'i' | 'o' | 'u' => *vowels.entry(c).or_insert(0) += 1,
            _ => *consonants.entry(c).or_insert(0) += 1,
        }
    }
    vowels.values().max().unwrap_or(&0) + consonants.values().max().unwrap_or(&0)
}

fn main() {
    println!("{}", max_freq_sum("successes".to_string())); // 6
    println!("{}", max_freq_sum("aeiaeia".to_string())); // 3
}
