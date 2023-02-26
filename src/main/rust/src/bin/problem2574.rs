// https://leetcode.com/problems/left-and-right-sum-differences/
pub fn left_rigth_difference(nums: Vec<i32>) -> Vec<i32> {
    let mut left_sum = vec![0; nums.len()];
    for i in 0..nums.len() - 1 {
        left_sum[i + 1] = if i == 0 { 0 } else { left_sum[i] } + nums[i];
    }
    let mut right_sum = vec![0; nums.len()];
    for i in (1..nums.len()).rev() {
        right_sum[i - 1] = if i == nums.len() - 1 { 0 } else { right_sum[i] } + nums[i];
    }
    let mut answer = vec![0; nums.len()];
    for i in 0..answer.len() {
        answer[i] = (left_sum[i] - right_sum[i]).abs();
    }
    answer
}

fn main() {
    println!("{:?}", left_rigth_difference(vec![10, 4, 8, 3])); // [15,1,11,22]
    println!("{:?}", left_rigth_difference(vec![1])); // [0]
}
