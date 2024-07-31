use std::collections::HashMap;

// https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter/
pub fn number_of_substrings(s: String) -> i64 {
    let mut answer: i64 = 0;
    let mut map: HashMap<char, i64> = HashMap::new();
    for c in s.chars() {
        let count = map.entry(c).or_insert(0);
        *count += 1;
        answer += *count;
    }
    answer
}

fn main() {
    println!("{}", number_of_substrings("abcba".to_string())); // 7
    println!("{}", number_of_substrings("abacad".to_string())); // 9
    println!("{}", number_of_substrings("a".to_string())); // 1
}
