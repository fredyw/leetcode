// https://leetcode.com/problems/median-of-a-row-wise-sorted-matrix/description/
pub fn matrix_median(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        matrix_median(vec![vec![1, 1, 2], vec![2, 3, 3], vec![1, 3, 4]])
    ); // 2
    println!("{}", matrix_median(vec![vec![1, 1, 3, 3, 4]])); // 3
    println!(
        "{}",
        matrix_median(vec![vec![1, 1, 1], vec![9, 9, 9], vec![7, 8, 8]])
    ); // 8
}
