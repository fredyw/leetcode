// https://leetcode.com/problems/minimize-maximum-of-array/description/
pub fn minimize_array_value(nums: Vec<i32>) -> i32 {
    let mut answer = nums[0];
    for i in 1..nums.len() {
        if nums[i - 1] < nums[i] {
            let n = (nums[i] - nums[i - 1]) / 2;
            let mid = if (nums[i] - nums[i - 1] + 1) % 2 == 0 {
                (nums[i - 1] + n) + 1
            } else {
                nums[i - 1] + n
            };
            answer = answer.max(mid);
        } else {
            answer = answer.max(nums[i]);
        }
    }
    answer
}

fn main() {
    // println!("{}", minimize_array_value(vec![3, 7, 1, 6])); // 5
    // println!("{}", minimize_array_value(vec![10, 1])); // 10
    // println!("{}", minimize_array_value(vec![1, 1, 1, 1])); // 1
    // println!("{}", minimize_array_value(vec![1, 10])); // 6
    println!("{}", minimize_array_value(vec![1, 2, 3, 4, 5])); // 3
                                                               // println!("{}", minimize_array_value(vec![1, 2, 4, 3, 4, 10, 2])); // 4
}
