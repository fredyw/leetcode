// https://leetcode.com/problems/longest-semi-repeating-subarray/description/
pub fn longest_subarray(nums: Vec<i32>, k: i32) -> i32 {
    todo!()
}

fn main() {
    println!("{}", longest_subarray(vec![1, 2, 3, 1, 2, 3, 4], 2)); // 6
    println!("{}", longest_subarray(vec![1, 1, 1, 1, 1], 4)); // 5
    println!("{}", longest_subarray(vec![1, 1, 1, 1, 1], 0)); // 1
}
