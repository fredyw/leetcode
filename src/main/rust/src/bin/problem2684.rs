// https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/description/
pub fn max_moves(grid: Vec<Vec<i32>>) -> i32 {
    fn max_moves(grid: &Vec<Vec<i32>>, row: i32, col: i32, memo: &mut Vec<Vec<i32>>) -> i32 {
        let num_rows = grid.len() as i32;
        let num_cols = if num_rows > 0 { grid[0].len() } else { 0 } as i32;
        if memo[row as usize][col as usize] != -1 {
            return memo[row as usize][col as usize];
        }
        let a = if row - 1 >= 0
            && col + 1 < num_cols
            && grid[row as usize][col as usize] < grid[row as usize - 1][col as usize + 1]
        {
            max_moves(grid, row - 1, col + 1, memo) + 1
        } else {
            0
        };
        let b = if col + 1 < num_cols
            && grid[row as usize][col as usize] < grid[row as usize][col as usize + 1]
        {
            max_moves(grid, row, col + 1, memo) + 1
        } else {
            0
        };
        let c = if row + 1 < num_rows
            && col + 1 < num_cols
            && grid[row as usize][col as usize] < grid[row as usize + 1][col as usize + 1]
        {
            max_moves(grid, row + 1, col + 1, memo) + 1
        } else {
            0
        };
        let max = a.max(b.max(c));
        memo[row as usize][col as usize] = max;
        max
    }

    let mut answer = 0;
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    for row in 0..grid.len() {
        answer = answer.max(max_moves(
            &grid,
            row as i32,
            0,
            &mut vec![vec![-1; num_cols]; num_rows],
        ));
    }
    answer
}

fn main() {
    println!(
        "{}",
        max_moves(vec![
            vec![2, 4, 3, 5],
            vec![5, 4, 9, 3],
            vec![3, 4, 2, 11],
            vec![10, 9, 13, 15]
        ])
    ); // 3
    println!(
        "{}",
        max_moves(vec![vec![3, 2, 4], vec![2, 1, 9], vec![1, 1, 7]])
    ); // 0
    println!("{}", max_moves(vec![vec![2, 4], vec![5, 4],])); // 1
    println!(
        "{}",
        max_moves(vec![
            vec![8, 4, 3, 5],
            vec![5, 4, 9, 3],
            vec![3, 4, 2, 11],
            vec![10, 9, 13, 15]
        ])
    ); // 3
}
