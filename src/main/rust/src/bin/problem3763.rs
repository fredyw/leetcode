// https://leetcode.com/problems/maximum-total-sum-with-threshold-constraints/
pub fn max_sum(nums: Vec<i32>, threshold: Vec<i32>) -> i64 {
    todo!()
}

fn main() {
    println!(
        "{}",
        max_sum(vec![1, 10, 4, 2, 1, 6], vec![5, 1, 5, 5, 2, 2])
    ); // 17
    println!("{}", max_sum(vec![4, 1, 5, 2, 3], vec![3, 3, 2, 3, 3])); // 0
    println!("{}", max_sum(vec![2, 6, 10, 13], vec![2, 1, 1, 1])); // 31
}
