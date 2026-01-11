use std::collections::HashSet;

// https://leetcode.com/problems/count-residue-prefixes/description/
pub fn residue_prefixes(s: String) -> i32 {
    let mut answer = 0;
    let mut counts: HashSet<char> = HashSet::new();
    for (i, c) in s.chars().enumerate() {
        counts.insert(c);
        if counts.len() == (i + 1) % 3 {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", residue_prefixes("abc".to_string())); // 2
    println!("{}", residue_prefixes("dd".to_string())); // 1
    println!("{}", residue_prefixes("bob".to_string())); // 2
}
