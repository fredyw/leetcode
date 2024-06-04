// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/
pub fn max_subarray_length(nums: Vec<i32>, k: i32) -> i32 {
    todo!()
}

fn main() {
    println!("{}", max_subarray_length(vec![1, 2, 3, 1, 2, 3, 1, 2], 2)); // 6
    println!("{}", max_subarray_length(vec![1, 2, 1, 2, 1, 2, 1, 2], 1)); // 2
    println!("{}", max_subarray_length(vec![5, 5, 5, 5, 5, 5, 5], 4)); // 4
}
