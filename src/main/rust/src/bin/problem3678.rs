use std::collections::HashSet;

// https://leetcode.com/problems/smallest-absent-positive-greater-than-average/description/
pub fn smallest_absent(nums: Vec<i32>) -> i32 {
    let set = nums.iter().copied().collect::<HashSet<i32>>();
    let mut avg = (nums.iter().sum::<i32>() as f32 / nums.len() as f32).ceil() as i32;
    while set.contains(&avg) {
        avg += 1;
    }
    avg
}

fn main() {
    println!("{}", smallest_absent(vec![3, 5])); // 6
    println!("{}", smallest_absent(vec![-1, 1, 2])); // 3
    println!("{}", smallest_absent(vec![4, -1])); // 2
}
