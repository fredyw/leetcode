use std::mem;

// https://leetcode.com/problems/minimum-unlocked-indices-to-sort-nums/description/
pub fn min_unlocked_indices(mut nums: Vec<i32>, locked: Vec<i32>) -> i32 {
    for i in 0..nums.len() - 1 {
        if nums[i] > nums[i + 1] {
            if locked[i] == 0 && nums[i] - nums[i + 1] == 1 {
                mem::swap(nums, i, i + 1);
            }
        }
    }
    todo!()
}

fn main() {
    println!(
        "{}",
        min_unlocked_indices(vec![1, 2, 1, 2, 3, 2], vec![1, 0, 1, 1, 0, 1])
    ); // 0
    println!(
        "{}",
        min_unlocked_indices(vec![1, 2, 1, 1, 3, 2, 2], vec![1, 0, 1, 1, 0, 1, 0])
    ); // 2
    println!(
        "{}",
        min_unlocked_indices(vec![1, 2, 1, 2, 3, 2, 1], vec![0, 0, 0, 0, 0, 0, 0])
    ); // -1
    println!("{}", min_unlocked_indices(vec![3, 2, 1], vec![0, 0, 0])); // -1
    println!("{}", min_unlocked_indices(vec![3, 2, 1], vec![1, 1, 1])); // -1
}
