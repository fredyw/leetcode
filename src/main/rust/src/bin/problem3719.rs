use std::collections::HashSet;

// https://leetcode.com/problems/longest-balanced-subarray-i/description/
pub fn longest_balanced(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() {
        let mut odds: HashSet<i32> = HashSet::new();
        let mut evens: HashSet<i32> = HashSet::new();
        for j in i..nums.len() {
            if nums[j] % 2 == 0 {
                evens.insert(nums[j]);
            } else {
                odds.insert(nums[j]);
            }
            if evens.len() == odds.len() {
                answer = answer.max((j - i) as i32 + 1);
            }
        }
    }
    answer
}

fn main() {
    println!("{}", longest_balanced(vec![2, 5, 4, 3])); // 4
    println!("{}", longest_balanced(vec![3, 2, 2, 5, 4])); // 5
    println!("{}", longest_balanced(vec![1, 2, 3, 2])); // 3
}
