// https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/
pub fn longest_monotonic_subarray(nums: Vec<i32>) -> i32 {
    let mut answer = 1;
    let mut inc_length = 1;
    let mut dec_length = 1;
    for i in 0..nums.len() - 1 {
        if nums[i] < nums[i + 1] {
            inc_length += 1;
        } else {
            inc_length = 1;
        }
        answer = answer.max(inc_length);
        if nums[i] > nums[i + 1] {
            dec_length += 1;
        } else {
            dec_length = 1;
        }
        answer = answer.max(dec_length);
    }
    answer
}

fn main() {
    println!("{}", longest_monotonic_subarray(vec![1, 4, 3, 3, 2])); // 2
    println!("{}", longest_monotonic_subarray(vec![3, 3, 3, 3])); // 1
    println!("{}", longest_monotonic_subarray(vec![3, 2, 1])); // 3
}
