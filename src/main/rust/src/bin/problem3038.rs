// https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/description/
pub fn max_operations(nums: Vec<i32>) -> i32 {
    let mut answer = 1;
    let sum = nums[0] + nums[1];
    let mut i = 2;
    while i < nums.len() - 1 && sum == nums[i] + nums[i + 1] {
        answer += 1;
        i += 2;
    }
    answer
}

fn main() {
    println!("{}", max_operations(vec![3, 2, 1, 4, 5])); // 2
    println!("{}", max_operations(vec![3, 2, 6, 1, 4])); // 1
    println!("{}", max_operations(vec![2, 2, 3, 2, 4, 2, 3, 3, 1, 3])); // 1
}
