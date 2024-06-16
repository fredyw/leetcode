use std::collections::HashMap;

// https://leetcode.com/problems/palindrome-permutation/description/
pub fn can_permute_palindrome(s: String) -> bool {
    let mut map: HashMap<char, i32> = HashMap::new();
    for char in s.chars() {
        *map.entry(char).or_insert(0) += 1;
    }
    let mut num_odd = 0;
    for (_, count) in map.into_iter() {
        if count % 2 != 0 {
            num_odd += 1;
        }
    }
    num_odd <= 1
}

fn main() {
    println!("{}", can_permute_palindrome("code".to_string())); // false
    println!("{}", can_permute_palindrome("aab".to_string())); // true
    println!("{}", can_permute_palindrome("carerac".to_string())); // true
}
