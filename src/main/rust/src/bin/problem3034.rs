// https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/description/
pub fn count_matching_subarrays(nums: Vec<i32>, pattern: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() {
        let mut j = i;
        let mut k = 0;
        while j + 1 < nums.len() && k < pattern.len() {
            if !((pattern[k] == 0 && nums[j] == nums[j + 1])
                || (pattern[k] < 0 && nums[j] > nums[j + 1])
                || (pattern[k] > 0 && nums[j] < nums[j + 1]))
            {
                break;
            }
            j += 1;
            k += 1;
        }
        if k == pattern.len() {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        count_matching_subarrays(vec![1, 2, 3, 4, 5, 6], vec![1, 1])
    ); // 4
    println!(
        "{}",
        count_matching_subarrays(vec![1, 4, 4, 1, 3, 5, 5, 3], vec![1, 0, -1])
    ); // 2
    println!(
        "{}",
        count_matching_subarrays(vec![1, 1, 1, 1, 1], vec![0, 0])
    ); // 3
}
