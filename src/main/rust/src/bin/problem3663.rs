use std::cmp::Ordering;
use std::collections::HashMap;

// https://leetcode.com/problems/find-the-least-frequent-digit/description/
pub fn get_least_frequent_digit(n: i32) -> i32 {
    let mut map: HashMap<char, i32> = HashMap::new();
    for x in n.to_string().chars() {
        *map.entry(x).or_insert(0) += 1;
    }
    n.to_string()
        .chars()
        .min_by(|x, y| {
            let cmp = map.get(x).cmp(&map.get(y));
            if cmp == Ordering::Equal {
                x.cmp(y)
            } else {
                cmp
            }
        })
        .unwrap()
        .to_digit(10)
        .unwrap() as i32
}

fn main() {
    println!("{}", get_least_frequent_digit(1553322)); // 1
    println!("{}", get_least_frequent_digit(723344511)); // 2
}
