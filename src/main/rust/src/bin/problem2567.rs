// https://leetcode.com/problems/minimum-score-by-changing-two-elements/
pub fn minimize_sum(mut nums: Vec<i32>) -> i32 {
    nums.sort();
    let a = (nums[1] - nums[nums.len() - 2]).abs();
    let b = (nums[0] - nums[nums.len() - 3]).abs();
    let c = (nums[2] - nums[nums.len() - 1]).abs();
    a.min(b).min(c)
}

fn main() {
    println!("{}", minimize_sum(vec![1, 1, 1])); // 0
    println!("{}", minimize_sum(vec![1, 4, 3])); // 0
    println!("{}", minimize_sum(vec![1, 4, 7, 8, 5])); // 3
    println!("{}", minimize_sum(vec![7, 7, 7, 8, 5])); // 0
    println!("{}", minimize_sum(vec![6, 6, 7, 8, 5])); // 1
    println!(" {}", minimize_sum(vec![6, 6, 7, 8, 80, 99, 100])); // 74
    println!("{}", minimize_sum(vec![1, 30, 55, 55, 75, 90])); // 35
}
