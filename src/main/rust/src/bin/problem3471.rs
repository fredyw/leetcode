use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/find-the-largest-almost-missing-integer/description/
pub fn largest_integer(nums: Vec<i32>, k: i32) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for i in 0..nums.len() - k as usize + 1 {
        let mut set: HashSet<i32> = HashSet::new();
        for j in i..i + k as usize {
            set.insert(nums[j]);
        }
        for n in set {
            *map.entry(n).or_insert(0) += 1;
        }
    }
    let mut answer = -1;
    for (n, count) in map {
        if count == 1 {
            answer = answer.max(n);
        }
    }
    answer
}

fn main() {
    println!("{}", largest_integer(vec![3, 9, 2, 1, 7], 3)); // 7
    println!("{}", largest_integer(vec![3, 9, 7, 2, 1, 7], 4)); // 3
    println!("{}", largest_integer(vec![0, 0], 1)); // -1
    println!("{}", largest_integer(vec![1, 2, 3, 4, 5], 5)); // 5
    println!("{}", largest_integer(vec![2, 2, 1], 3)); // 2
}
