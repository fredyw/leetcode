use std::collections::HashSet;

// https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/description/
pub fn sum_counts(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() {
        let mut set: HashSet<i32> = HashSet::new();
        for j in i..nums.len() {
            set.insert(nums[j]);
            answer += set.len() as i32 * set.len() as i32;
        }
    }
    answer
}

fn main() {
    println!("{}", sum_counts(vec![1, 2, 1])); // 15
    println!("{}", sum_counts(vec![1, 1])); // 3
}
