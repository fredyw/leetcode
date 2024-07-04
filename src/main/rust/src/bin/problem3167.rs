use std::collections::BTreeMap;

// https://leetcode.com/problems/better-compression-of-string/description/
pub fn better_compression(compressed: String) -> String {
    let mut map: BTreeMap<char, i32> = BTreeMap::new();
    let mut char = ' ';
    let mut num = String::new();
    for c in compressed.chars() {
        if c.is_numeric() {
            num.push(c);
        } else {
            if !num.is_empty() {
                *map.entry(char).or_insert(0) += num.parse::<i32>().unwrap();
            }
            num.clear();
            char = c;
        }
    }
    *map.entry(char).or_insert(0) += num.parse::<i32>().unwrap();
    let mut answer = String::new();
    for (char, count) in map.into_iter() {
        answer.push(char);
        answer.push_str(&count.to_string());
    }
    answer
}

fn main() {
    println!("{}", better_compression("a3c9b2c1".to_string())); // "a3b2c10"
    println!("{}", better_compression("c2b3a1".to_string())); // "a1b3c2"
    println!("{}", better_compression("a2b4c1".to_string())); // "a2b4c1"
}
