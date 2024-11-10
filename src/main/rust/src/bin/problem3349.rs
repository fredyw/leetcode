// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/description/
pub fn has_increasing_subarrays(nums: Vec<i32>, k: i32) -> bool {
    let mut i = 0;
    let mut left_length = 1;
    let mut right_length = 1;
    while i < nums.len() - 1 {
        if nums[i] < nums[i + 1] {
            if left_length < k {
                left_length += 1;
            } else {
                right_length += 1;
            }
        } else {
            if left_length < k {
                left_length = 1;
            }
        }
        if left_length >= k && right_length >= k {
            return true;
        }
        i += 1;
    }
    false
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
    println!(
        "{}",
        has_increasing_subarrays(vec![1, 2, 3, 4, 4, 4, 4, 5, 6, 7], 2)
    ); // true
    println!(
        "{}",
        has_increasing_subarrays(vec![1, 2, 3, 4, 4, 4, 4, 5, 6, 7], 1)
    ); // true
    println!(
        "{}",
        has_increasing_subarrays(vec![1, 2, 3, 4, 4, 4, 4, 5, 6, 7], 3)
    ); // false
}
