// https://leetcode.com/problems/relocate-marbles/
pub fn relocate_marbles(nums: Vec<i32>, move_from: Vec<i32>, move_to: Vec<i32>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        relocate_marbles(vec![1, 6, 7, 8], vec![1, 7, 2], vec![2, 9, 5])
    ); // [5,6,8,9]
    println!(
        "{:?}",
        relocate_marbles(vec![1, 1, 3, 3], vec![1, 3], vec![2, 2])
    ); // [2]
}
