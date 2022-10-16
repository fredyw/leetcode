use std::collections::HashSet;

// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
pub fn find_max_k(nums: Vec<i32>) -> i32 {
    let mut answer = -1;
    let positive_nums: HashSet<&i32> = nums.iter().filter(|a| **a > 0).collect();
    let negative_nums: HashSet<&i32> = nums.iter().filter(|a| **a < 0).collect();
    for positive_num in positive_nums.into_iter() {
        if negative_nums.contains(&-positive_num) {
            answer = answer.max(*positive_num);
        }
    }
    answer
}

fn main() {
    println!("{}", find_max_k(vec![-1, 2, -3, 3])); // 3
    println!("{}", find_max_k(vec![-1, 10, 6, 7, -7, 1])); // 7
    println!("{}", find_max_k(vec![-10, 8, 6, 7, -2, -3])); // -1
}
