// https://leetcode.com/problems/count-subarrays-with-majority-element-i/description/
pub fn count_majority_subarrays(nums: Vec<i32>, target: i32) -> i32 {
    todo!()
}

fn main() {
    println!("{}", count_majority_subarrays(vec![1, 2, 2, 3], 2)); // 5
    println!("{}", count_majority_subarrays(vec![1, 1, 1, 1], 1)); // 10
    println!("{}", count_majority_subarrays(vec![1, 2, 3], 4)); // 0
}
