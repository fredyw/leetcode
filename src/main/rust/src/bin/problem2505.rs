// https://leetcode.com/problems/bitwise-or-of-all-subsequence-sums/description/
pub fn subsequence_sum_or(nums: Vec<i32>) -> i64 {
    let mut answer: i64 = 0;
    let mut sum: i64 = 0;
    for i in 0..nums.len() {
        answer |= nums[i] as i64;
        sum += nums[i] as i64;
        answer |= sum;
    }
    answer
}

fn main() {
    println!("{}", subsequence_sum_or(vec![2, 1, 0, 3])); // 7
    println!("{}", subsequence_sum_or(vec![0, 0, 0])); // 0
    println!("{}", subsequence_sum_or(vec![1, 100, 5])); // 111
    println!("{}", subsequence_sum_or(vec![24, 1, 3, 16, 12, 37])); // 127
}
