use std::collections::HashMap;

// https://leetcode.com/problems/minimum-number-of-keypresses/
pub fn minimum_keypresses(s: String) -> i32 {
    let mut map: HashMap<char, i32> = HashMap::new();
    for char in s.chars() {
        *map.entry(char).or_insert(0) += 1;
    }
    let mut v: Vec<(i32, char)> = map.into_iter().map(|(char, count)| (count, char)).collect();
    v.sort_by(|a, b| b.cmp(a));
    let mut answer = 0;
    let mut num_chars = 0;
    for (count, _) in v.into_iter() {
        num_chars += 1;
        let num_keypresses = if num_chars <= 9 {
            1
        } else if num_chars >= 10 && num_chars <= 18 {
            2
        } else {
            3
        };
        answer += num_keypresses * count;
    }
    answer
}

fn main() {
    println!("{}", minimum_keypresses("apple".to_string())); // 5
    println!("{}", minimum_keypresses("abcdefghijkl".to_string())); // 15
}
