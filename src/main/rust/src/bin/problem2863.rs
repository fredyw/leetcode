// https://leetcode.com/problems/maximum-length-of-semi-decreasing-subarrays/description/
pub fn max_subarray_length(nums: Vec<i32>) -> i32 {
    todo!()
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
}
