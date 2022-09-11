use std::cmp::Ordering;
use std::collections::HashMap;

// https://leetcode.com/problems/most-frequent-even-element/
pub fn most_frequent_even(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in nums.into_iter() {
        if num % 2 == 0 {
            *map.entry(num).or_insert(0) += 1;
        }
    }
    if map.is_empty() {
        -1
    } else {
        *map.iter()
            .max_by(|a, b| match a.1.cmp(b.1) {
                Ordering::Equal => b.0.cmp(a.0),
                _ => a.1.cmp(b.1),
            })
            .unwrap()
            .0
    }
}

fn main() {
    println!("{}", most_frequent_even(vec![0, 1, 2, 2, 4, 4, 1])); // 2
    println!("{}", most_frequent_even(vec![4, 4, 4, 9, 2, 4])); // 4
    println!(
        "{}",
        most_frequent_even(vec![29, 47, 21, 41, 13, 37, 25, 7])
    ); // -1
}
