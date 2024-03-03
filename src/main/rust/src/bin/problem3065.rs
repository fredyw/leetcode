// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/description/
pub fn min_operations(nums: Vec<i32>, k: i32) -> i32 {
    nums.into_iter().filter(|n| *n < k).count() as i32
}

fn main() {
    println!("{}", min_operations(vec![2, 11, 10, 1, 3], 10)); // 3
    println!("{}", min_operations(vec![1, 1, 2, 4, 9], 1)); // 0
    println!("{}", min_operations(vec![1, 1, 2, 4, 9], 9)); // 4
}
