use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/palindrome-permutation-ii/description/
pub fn generate_palindromes(s: String) -> Vec<String> {
    fn permutations(
        even_chars: &mut Vec<char>,
        odd_char: char,
        index: usize,
        palindromes: &mut HashSet<String>,
    ) {
        let mut palindrome: String = even_chars.iter().collect();
        if odd_char != ' ' {
            palindrome.push(odd_char);
        }
        palindrome.push_str(&even_chars.iter().rev().collect::<String>());
        palindromes.insert(palindrome);
        for i in index..even_chars.len() {
            even_chars.swap(index, i);
            permutations(even_chars, odd_char, index + 1, palindromes);
            even_chars.swap(i, index);
        }
    }

    let mut map: HashMap<char, i32> = HashMap::new();
    for char in s.chars() {
        *map.entry(char).or_insert(0) += 1;
    }
    let mut odd_count = 0;
    let mut even_chars: Vec<char> = vec![];
    let mut odd_char = ' ';
    for (char, count) in map.iter() {
        if *count % 2 != 0 {
            odd_count += 1;
        }
        if odd_count > 1 {
            return vec![];
        }
        for _ in 0..count / 2 {
            even_chars.push(*char);
        }
        if *count % 2 != 0 {
            odd_char = *char;
        }
    }

    let mut answer = HashSet::new();
    permutations(&mut even_chars, odd_char, 0, &mut answer);
    answer.into_iter().collect()
}

fn main() {
    // permutations(&mut vec![1, 2, 3], 0);
    println!("{:?}", generate_palindromes("aabb".to_string())); // ["abba","baab"]
    println!("{:?}", generate_palindromes("abc".to_string())); // []
    println!("{:?}", generate_palindromes("aaabbb".to_string())); // []
    println!("{:?}", generate_palindromes("aabbc".to_string())); // ["abcba","bacab"]
    println!("{:?}", generate_palindromes("aaabb".to_string())); // ["ababa","baaab"]
    println!("{:?}", generate_palindromes("aaaabbbb".to_string())); // ["aabbbbaa","ababbaba","abbaabba","baabbaab","babaabab","bbaaaabb"]
    println!("{:?}", generate_palindromes("a".to_string())); // ["a"]
}
