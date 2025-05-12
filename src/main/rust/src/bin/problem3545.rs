use std::collections::HashMap;

// https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters/description/
pub fn min_deletion(s: String, k: i32) -> i32 {
    let mut map: HashMap<char, i32> = HashMap::new();
    for c in s.chars() {
        *map.entry(c).or_insert(0) += 1;
    }
    let mut v: Vec<i32> = map.iter().map(|e| *e.1).collect();
    v.sort_by(|a, b| b.cmp(&a));
    let mut answer = 0;
    for i in k as usize..v.len() {
        answer += v[i];
    }
    answer
}

fn main() {
    println!("{}", min_deletion("abc".to_string(), 2)); // 1
    println!("{}", min_deletion("aabb".to_string(), 2)); // 0
    println!("{}", min_deletion("yyyzz".to_string(), 1)); // 2
}
