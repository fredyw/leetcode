use std::collections::HashSet;

// https://leetcode.com/problems/number-of-centered-subarrays/description/
pub fn centered_subarrays(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let unique_nums: HashSet<i32> = nums.iter().copied().collect();
    for i in 0..nums.len() {
        let mut sum = 0;
        for j in i..nums.len() {
            sum += nums[j];
            if unique_nums.contains(&sum) {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", centered_subarrays(vec![-1, 1, 0])); // 5
    println!("{}", centered_subarrays(vec![2, -3])); // 2
}
