// https://leetcode.com/problems/maximum-total-subarray-value-i/description/
pub fn max_total_value(nums: Vec<i32>, k: i32) -> i64 {
    let min = *nums.iter().min().unwrap() as i64;
    let max = *nums.iter().max().unwrap() as i64;
    (max - min) * k as i64
}

fn main() {
    println!("{}", max_total_value(vec![1, 3, 2], 2)); // 4
    println!("{}", max_total_value(vec![4, 2, 5, 1], 3)); // 12
}
