// https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/
pub fn max_adjacent_distance(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() {
        if i == nums.len() - 1 {
            answer = answer.max((nums[i] - nums[0]).abs());
        } else {
            answer = answer.max((nums[i] - nums[i + 1]).abs());
        }
    }
    answer
}

fn main() {
    println!("{}", max_adjacent_distance(vec![1, 2, 4])); // 3
    println!("{}", max_adjacent_distance(vec![-5, -10, -5])); // 5
}
