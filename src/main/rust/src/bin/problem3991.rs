use std::collections::{HashSet, VecDeque};

// https://leetcode.com/problems/sort-array-using-prefix-reversals/description/
pub fn sort_array(nums: Vec<i32>, pre: Vec<i32>) -> i32 {
    let target: Vec<i32> = (0..nums.len() as i32).collect();
    if nums == target {
        return 0;
    }
    let mut queue = VecDeque::new();
    let mut visited = HashSet::new();
    queue.push_back((nums.clone(), 0));
    visited.insert(nums);
    while let Some((curr, steps)) = queue.pop_front() {
        for &len in &pre {
            let len = len as usize;
            if len > curr.len() {
                continue;
            }
            let mut next_arr = curr.clone();
            next_arr[0..len].reverse();
            if next_arr == target {
                return steps + 1;
            }
            if visited.insert(next_arr.clone()) {
                queue.push_back((next_arr, steps + 1));
            }
        }
    }
    -1
}

fn main() {
    println!("{}", sort_array(vec![2, 0, 1], vec![2, 3])); // 2
    println!("{}", sort_array(vec![1, 0, 2], vec![1, 3])); // -1
    println!("{}", sort_array(vec![0, 1], vec![2])); // 0
    println!("{}", sort_array(vec![0, 2, 1], vec![3, 2, 1])); // 3
}
