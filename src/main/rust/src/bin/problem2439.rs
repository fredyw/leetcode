// https://leetcode.com/problems/minimize-maximum-of-array/description/
pub fn minimize_array_value(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut sum: i64 = 0;
    for i in 0..nums.len() {
        sum += nums[i] as i64;
        let average = (sum as f64 / (i as i64 + 1) as f64).ceil() as i64;
        answer = answer.max(average);
    }
    answer as i32
}

fn main() {
    println!("{}", minimize_array_value(vec![3, 7, 1, 6])); // 5
    println!("{}", minimize_array_value(vec![10, 1])); // 10
    println!("{}", minimize_array_value(vec![1, 1, 1, 1])); // 1
    println!("{}", minimize_array_value(vec![1, 10])); // 6
    println!("{}", minimize_array_value(vec![5, 4, 3, 2, 1])); // 5
    println!("{}", minimize_array_value(vec![1, 2, 3, 4, 5])); // 3
    println!("{}", minimize_array_value(vec![1, 2, 4, 3, 4, 10])); // 4
}
