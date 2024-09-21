// https://leetcode.com/problems/median-of-a-row-wise-sorted-matrix/description/
pub fn matrix_median(grid: Vec<Vec<i32>>) -> i32 {
    let mut min = i32::MAX;
    let mut max = i32::MIN;
    for i in 0..grid.len() {
        min = min.min(grid[i][0]);
        max = max.max(grid[i][grid[i].len() - 1]);
    }
    0
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
