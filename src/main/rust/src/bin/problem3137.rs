use std::collections::HashMap;

// https://leetcode.com/problems/minimum-number-of-operations-to-make-word-k-periodic/description/
pub fn minimum_operations_to_make_k_periodic(word: String, k: i32) -> i32 {
    let mut map: HashMap<&str, i32> = HashMap::new();
    let mut i = 0;
    while i < word.len() {
        let sub = &word[i..i + k as usize];
        *map.entry(sub).or_insert(0) += 1;
        i += k as usize;
    }
    let mut max = 0;
    for (_, count) in map.iter() {
        max = max.max(*count);
    }
    (word.len() as i32 - (k * max)) / k
}

fn main() {
    println!(
        "{}",
        minimum_operations_to_make_k_periodic("leetcodeleet".to_string(), 4)
    ); // 1
    println!(
        "{}",
        minimum_operations_to_make_k_periodic("leetcoleet".to_string(), 2)
    ); // 3
    println!(
        "{}",
        minimum_operations_to_make_k_periodic("leetcoleet".to_string(), 2)
    ); // 2
}
