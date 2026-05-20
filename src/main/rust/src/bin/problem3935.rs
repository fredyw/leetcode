// https://leetcode.com/problems/power-update-after-k-th-largest-insertion-i/description/
pub fn power_update(nums: Vec<i32>, p: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        power_update(vec![2], 4, vec![vec![3, 1], vec![1, 2]])
    ); // [64,4096]
    println!(
        "{:?}",
        power_update(vec![7, 5], 6, vec![vec![4, 3], vec![7, 2]])
    ); // [1296,220296870]
}
