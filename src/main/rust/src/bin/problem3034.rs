// https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/description/
pub fn count_matching_subarrays(nums: Vec<i32>, pattern: Vec<i32>) -> i32 {
    todo!()
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
