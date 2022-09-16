// https://leetcode.com/problems/longest-nice-subarray/
pub fn longest_nice_subarray(nums: Vec<i32>) -> i32 {
    let mut answer = 0i32;
    let mut j = 0;
    let mut i = 0;
    let mut mask = 0;
    while i < nums.len() {
        while mask & nums[i] != 0 {
            mask ^= nums[j];
            j += 1;
        }
        mask = mask | nums[i];
        i += 1;
        answer = answer.max((i - j) as i32);
    }
    answer
}

fn main() {
    println!("{}", longest_nice_subarray(vec![1, 3, 8, 48, 10])); // 3
    println!("{}", longest_nice_subarray(vec![3, 1, 5, 11, 13])); // 1
}
