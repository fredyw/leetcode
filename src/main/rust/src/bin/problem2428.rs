// https://leetcode.com/problems/maximum-sum-of-an-hourglass/
pub fn max_sum(grid: Vec<Vec<i32>>) -> i32 {
    fn hourglass_sum(grid: &Vec<Vec<i32>>, row: usize, col: usize) -> i32 {
        let max_row = grid.len();
        let max_col = if max_row > 0 { grid[0].len() } else { 0 };
        if row + 2 >= max_row || col + 2 >= max_col {
            return 0;
        }
        grid[row][col]
            + grid[row][col + 1]
            + grid[row][col + 2]
            + grid[row + 1][col + 1]
            + grid[row + 2][col]
            + grid[row + 2][col + 1]
            + grid[row + 2][col + 2]
    }

    let mut answer = 0;
    for i in 0..grid.len() {
        for j in 0..grid[i].len() {
            answer = answer.max(hourglass_sum(&grid, i, j));
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        max_sum(vec![
            vec![6, 2, 1, 3],
            vec![4, 2, 1, 5],
            vec![9, 2, 8, 7],
            vec![4, 1, 2, 9]
        ])
    ); // 30
    println!(
        "{}",
        max_sum(vec![vec![1, 2, 3], vec![4, 5, 6], vec![7, 8, 9]])
    ); // 35
}
