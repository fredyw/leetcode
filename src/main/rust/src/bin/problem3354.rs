// https://leetcode.com/problems/make-array-elements-equal-to-zero/
pub fn count_valid_selections(nums: Vec<i32>) -> i32 {
    0
}

fn main() {
    println!("{}", count_valid_selections(vec![1, 0, 2, 0, 3])); // 2
    println!("{}", count_valid_selections(vec![2, 3, 4, 0, 4, 1, 0])); // 0
    println!("{}", count_valid_selections(vec![2, 3, 0, 0, 4, 1, 0])); // 4
    println!("{}", count_valid_selections(vec![2, 3, 0, 0, 4, 1, 1])); // 2
}
