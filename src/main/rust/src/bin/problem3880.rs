// https://leetcode.com/problems/minimum-absolute-difference-between-two-values/description/
pub fn min_absolute_difference(nums: Vec<i32>) -> i32 {
    let mut answer = i32::MAX;
    for i in 0..nums.len() {
        for j in i + 1..nums.len() {
            if (nums[i] == 1 && nums[j] == 2) || (nums[i] == 2 && nums[j] == 1) {
                answer = answer.min(j as i32 - i as i32);
            }
        }
    }
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    println!("{}", min_absolute_difference(vec![1, 0, 0, 2, 0, 1])); // 2
    println!("{}", min_absolute_difference(vec![1, 0, 1, 0])); // -1
}
