// https://leetcode.com/problems/first-completely-painted-row-or-column/
pub fn first_complete_index(arr: Vec<i32>, mat: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        first_complete_index(vec![1, 3, 4, 2], vec![vec![1, 4], vec![2, 3]])
    ); // 2
    println!(
        "{}",
        first_complete_index(
            vec![2, 8, 7, 4, 1, 3, 5, 6, 9],
            vec![vec![3, 2, 5], vec![1, 4, 6], vec![8, 7, 9]]
        )
    ); // 3
}
