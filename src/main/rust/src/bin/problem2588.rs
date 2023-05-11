use std::collections::HashMap;

// https://leetcode.com/problems/count-the-number-of-beautiful-subarrays/
pub fn beautiful_subarrays(nums: Vec<i32>) -> i64 {
    let mut answer = 0;
    let mut counts: HashMap<i32, i32> = HashMap::new();
    counts.insert(0, 1);
    let mut prefix_xor = 0;
    for i in 0..nums.len() {
        prefix_xor ^= nums[i];
        answer += *counts.get(&prefix_xor).unwrap_or(&0) as i64;
        *counts.entry(prefix_xor).or_insert(0) += 1
    }
    answer
}

fn main() {
    println!("{}", beautiful_subarrays(vec![4, 3, 1, 2, 4])); // 2
    println!("{}", beautiful_subarrays(vec![4, 3, 1, 2, 4, 4])); // 4
    println!("{}", beautiful_subarrays(vec![1, 10, 4])); // 0
    println!("{}", beautiful_subarrays(vec![3, 4])); // 0
    println!("{}", beautiful_subarrays(vec![1])); // 0
}
