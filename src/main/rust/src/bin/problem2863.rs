use std::collections::VecDeque;

// https://leetcode.com/problems/maximum-length-of-semi-decreasing-subarrays/description/
pub fn max_subarray_length(nums: Vec<i32>) -> i32 {
    let mut deque: VecDeque<usize> = VecDeque::new();
    for i in (0..nums.len()).rev() {
        if deque.is_empty() || nums[*deque.back().unwrap()] > nums[i] {
            deque.push_back(i);
        }
    }
    let mut answer = 0;
    for i in 0..nums.len() {
        while !deque.is_empty() && nums[*deque.back().unwrap()] < nums[i] {
            let j = deque.pop_back().unwrap();
            answer = answer.max(j as i32 - i as i32 + 1);
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        max_subarray_length(vec![7, 6, 5, 4, 3, 2, 1, 6, 10, 11])
    ); // 8
    println!(
        "{}",
        max_subarray_length(vec![57, 55, 50, 60, 61, 58, 63, 59, 64, 60, 63])
    ); // 6
    println!("{}", max_subarray_length(vec![1, 2, 3, 4])); // 0
    println!(
        "{}",
        max_subarray_length(vec![7, 6, 5, 4, 3, 2, 1, 6, 1, 10, 11])
    ); // 9
}
