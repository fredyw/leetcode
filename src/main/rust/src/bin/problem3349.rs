// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/description/
pub fn has_increasing_subarrays(nums: Vec<i32>, k: i32) -> bool {
    todo!()
}

fn main() {
    println!(
        "{}",
        has_increasing_subarrays(vec![2, 5, 7, 8, 9, 2, 3, 4, 3, 1], 3)
    ); // true
    println!(
        "{}",
        has_increasing_subarrays(vec![1, 2, 3, 4, 4, 4, 4, 5, 6, 7], 5)
    ); // false
}
