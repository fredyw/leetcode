// https://leetcode.com/problems/maximize-expression-of-three-elements/description/
pub fn maximize_expression_of_three(mut nums: Vec<i32>) -> i32 {
    nums.sort();
    nums[nums.len() - 1] + nums[nums.len() - 2] - nums[0]
}

fn main() {
    println!("{}", maximize_expression_of_three(vec![1, 4, 2, 5])); // 8
    println!("{}", maximize_expression_of_three(vec![-2, 0, 5, -2, 4])); // 11
}
