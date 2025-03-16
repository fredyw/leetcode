// https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/
pub fn max_sum(nums: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", max_sum(vec![1, 2, 3, 4, 5])); // 15
    println!("{}", max_sum(vec![1, 1, 0, 1, 1])); // 1
    println!("{}", max_sum(vec![1, 2, -1, -2, 1, 0, -1])); // 3
    println!("{}", max_sum(vec![-3, -2, -3, -1])); // -1
}
