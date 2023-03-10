// https://leetcode.com/problems/minimum-score-by-changing-two-elements/
pub fn minimize_sum(nums: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", minimize_sum(vec![1, 4, 3])); // 0
    println!("{}", minimize_sum(vec![1, 4, 7, 8, 5])); // 3
    println!("{}", minimize_sum(vec![7, 7, 7, 8, 5])); // 0
    println!("{}", minimize_sum(vec![6, 6, 7, 8, 5])); // 1
    println!("{}", minimize_sum(vec![6, 6, 7, 8, 5])); // 3
    println!("{}", minimize_sum(vec![6, 6, 7, 8, 80, 99, 100])); // 74
}
