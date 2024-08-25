use std::collections::VecDeque;

// https://leetcode.com/problems/maximum-length-of-semi-decreasing-subarrays/description/
pub fn max_subarray_length(nums: Vec<i32>) -> i32 {
    let mut next_smaller_elements = vec![-1; nums.len()];
    let mut deque: VecDeque<usize> = VecDeque::new();
    for (i, n) in nums.iter().enumerate() {
        while !deque.is_empty() && nums[*deque.front().unwrap()] > nums[i] {
            let index = deque.pop_front().unwrap();
            next_smaller_elements[index] = nums[i];
        }
        deque.push_back(i);
    }
    println!("{:?}", next_smaller_elements);
    let mut new_nums: Vec<(i32, usize)> = nums.iter().enumerate().map(|(i, n)| (*n, i)).collect();
    new_nums.sort_by(|a, b| b.0.cmp(&a.0));
    println!("{:?}", new_nums);
    0
}

fn main() {
    // println!(
    //     "{}",
    //     max_subarray_length(vec![7, 6, 5, 4, 3, 2, 1, 6, 10, 11])
    // ); // 8
    // println!(
    //     "{}",
    //     max_subarray_length(vec![57, 55, 50, 60, 61, 58, 63, 59, 64, 60, 63])
    // ); // 6
    // println!("{}", max_subarray_length(vec![1, 2, 3, 4])); // 0
    println!(
        "{}",
        max_subarray_length(vec![7, 6, 5, 4, 3, 2, 1, 6, 1, 10, 11])
    ); // 9
}
