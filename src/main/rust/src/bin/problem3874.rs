// https://leetcode.com/problems/valid-subarrays-with-exactly-one-peak/description/
pub fn valid_subarrays(nums: Vec<i32>, k: i32) -> i64 {
    todo!()
}

fn main() {
    println!("{}", valid_subarrays(vec![1, 3, 2], 1)); // 4
    println!("{}", valid_subarrays(vec![7, 8, 9], 2)); // 0
    println!("{}", valid_subarrays(vec![4, 3, 5, 1], 2)); // 6
    println!("{}", valid_subarrays(vec![1, 4, 2, 5, 2], 5)); // 8
    println!("{}", valid_subarrays(vec![1, 3, 2, 4, 3, 5, 1, 4, 2], 2)); // 16
}
