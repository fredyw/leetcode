// https://leetcode.com/problems/minimum-unlocked-indices-to-sort-nums/description/
pub fn min_unlocked_indices(nums: Vec<i32>, locked: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        min_unlocked_indices(vec![1, 2, 1, 2, 3, 2], vec![1, 0, 1, 1, 0, 1])
    ); // 0
    println!(
        "{}",
        min_unlocked_indices(vec![1, 2, 1, 1, 3, 2, 2], vec![1, 0, 1, 1, 0, 1, 0])
    ); // 2
    println!(
        "{}",
        min_unlocked_indices(vec![1, 2, 1, 2, 3, 2, 1], vec![0, 0, 0, 0, 0, 0, 0])
    ); // -1
}
