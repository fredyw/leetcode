// https://leetcode.com/problems/cherry-pickup-ii/
pub fn cherry_pickup(grid: Vec<Vec<i32>>) -> i32 {
    fn f(
        grid: &Vec<Vec<i32>>,
        row1: i32,
        col1: i32,
        row2: i32,
        col2: i32,
        memo: &mut Vec<Vec<Vec<Vec<i32>>>>,
    ) -> i32 {
        let max_row = grid.len() as i32;
        let max_col = if max_row > 1 { grid[0].len() } else { 0 } as i32;
        if row1 < 0
            || row2 < 0
            || col1 < 0
            || col2 < 0
            || row1 == max_row
            || row2 == max_row
            || col1 == max_col
            || col2 == max_col
            || (row1 == row2 && col1 == col2)
        {
            return 0;
        }
        if memo[row1 as usize][col1 as usize][row2 as usize][col2 as usize] != -1 {
            return memo[row1 as usize][col1 as usize][row2 as usize][col2 as usize];
        }
        let mut max = 0;
        let value = grid[row1 as usize][col1 as usize] + grid[row2 as usize][col2 as usize];
        for (r1, c1) in [(row1 + 1, col1 - 1), (row1 + 1, col1), (row1 + 1, col1 + 1)] {
            for (r2, c2) in [(row2 + 1, col2 - 1), (row2 + 1, col2), (row2 + 1, col2 + 1)] {
                max = max.max(f(&grid, r1, c1, r2, c2, memo) + value);
            }
        }
        memo[row1 as usize][col1 as usize][row2 as usize][col2 as usize] = max;
        max
    }

    let max_row = grid.len();
    let max_col = if max_row > 1 { grid[0].len() } else { 0 };
    let mut memo = vec![vec![vec![vec![-1; max_col]; max_row]; max_col]; max_row];
    f(&grid, 0, 0, 0, max_col as i32 - 1, &mut memo)
}

fn main() {
    println!(
        "{}",
        cherry_pickup(vec![
            vec![3, 1, 1],
            vec![2, 5, 1],
            vec![1, 5, 5],
            vec![2, 1, 1]
        ])
    ); // 24
    println!(
        "{}",
        cherry_pickup(vec![
            vec![1, 0, 0, 0, 0, 0, 1],
            vec![2, 0, 0, 0, 0, 3, 0],
            vec![2, 0, 9, 0, 0, 0, 0],
            vec![0, 3, 0, 5, 4, 0, 0],
            vec![1, 0, 2, 3, 0, 0, 6]
        ])
    ); // 28
    println!("{}", cherry_pickup(vec![vec![3, 1, 1], vec![2, 5, 1],])); // 11
}
