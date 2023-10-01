use std::collections::HashSet;

// https://leetcode.com/problems/minimum-operations-to-collect-elements/description/
pub fn min_operations(nums: Vec<i32>, k: i32) -> i32 {
    let mut set: HashSet<i32> = (1..=k).into_iter().collect();
    for (i, n) in nums.iter().rev().enumerate() {
        set.remove(n);
        if set.len() == 0 {
            return i as i32 + 1;
        }
    }
    nums.len() as i32 + 1
}

fn main() {
    println!("{}", min_operations(vec![3, 1, 5, 4, 2], 2)); // 4
    println!("{}", min_operations(vec![3, 1, 5, 4, 2], 5)); // 5
    println!("{}", min_operations(vec![3, 2, 5, 3, 1], 3)); // 4
}
