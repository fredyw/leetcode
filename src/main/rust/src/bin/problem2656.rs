// https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/
pub fn maximize_sum(nums: Vec<i32>, k: i32) -> i32 {
    let max = nums.into_iter().max().unwrap();
    (1..k).into_iter().fold(max, |acc, i| acc + max + i)
}

fn main() {
    println!("{}", maximize_sum(vec![1, 2, 3, 4, 5], 3)); // 18
    println!("{}", maximize_sum(vec![5, 5, 5], 2)); // 11
}
