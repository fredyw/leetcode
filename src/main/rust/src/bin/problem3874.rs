// https://leetcode.com/problems/valid-subarrays-with-exactly-one-peak/description/
pub fn valid_subarrays(nums: Vec<i32>, k: i32) -> i64 {
    let mut answer = 0;
    let k = k as i64;
    let mut peaks: Vec<i64> = Vec::new();
    for i in 1..nums.len() - 1 {
        if nums[i] > nums[i - 1] && nums[i] > nums[i + 1] {
            peaks.push(i as i64);
        }
    }
    for (idx, &i) in peaks.iter().enumerate() {
        let prev_peak = if idx > 0 { peaks[idx - 1] + 1 } else { 0 };
        let left = i - 0.max(i - k).max(prev_peak) + 1;
        let next_peak = if idx + 1 < peaks.len() {
            peaks[idx + 1] - 1
        } else {
            nums.len() as i64 - 1
        };
        let right = (nums.len() as i64 - 1).min(i + k).min(next_peak) - i + 1;
        answer += left * right;
    }
    answer
}

fn main() {
    println!("{}", valid_subarrays(vec![1, 3, 2], 1)); // 4
    println!("{}", valid_subarrays(vec![7, 8, 9], 2)); // 0
    println!("{}", valid_subarrays(vec![4, 3, 5, 1], 2)); // 6
    println!("{}", valid_subarrays(vec![1, 4, 2, 5, 2], 5)); // 8
    println!("{}", valid_subarrays(vec![1, 3, 2, 4, 3, 5, 1, 4, 2], 2)); // 16
    println!("{}", valid_subarrays(vec![1, 3, 2, 4, 3, 5, 1, 4, 2], 3)); // 16
}
