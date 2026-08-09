// https://leetcode.com/problems/remove-methods-from-project/description/
pub fn remaining_methods(n: i32, k: i32, invocations: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        remaining_methods(4, 1, vec![vec![1, 2], vec![0, 1], vec![3, 2]])
    ); // [0,1,2,3]
    println!(
        "{:?}",
        remaining_methods(5, 0, vec![vec![1, 2], vec![0, 2], vec![0, 1], vec![3, 4]])
    ); // [3,4]
    println!(
        "{:?}",
        remaining_methods(3, 2, vec![vec![1, 2], vec![0, 1], vec![2, 0]])
    ); // []
}
