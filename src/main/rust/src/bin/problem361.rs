// https://leetcode.com/problems/bomb-enemy/description/
pub fn max_killed_enemies(grid: Vec<Vec<char>>) -> i32 {
    let mut answer = 0;
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    let mut left_sums = vec![vec![0; num_cols]; num_rows];
    let mut right_sums = vec![vec![0; num_cols]; num_rows];
    for row in 0..num_rows {
        for col in 0..num_cols {
            if grid[row][col] == 'W' {
                left_sums[row][col] = 0;
            } else if grid[row][col] == 'E' {
                left_sums[row][col] = if col as isize - 1 < 0 {
                    0
                } else {
                    left_sums[row][col - 1]
                } + 1;
            } else {
                left_sums[row][col] = if col as isize - 1 < 0 {
                    0
                } else {
                    left_sums[row][col - 1]
                };
            }
            let right_col = num_cols - col - 1;
            if grid[row][right_col] == 'W' {
                right_sums[row][right_col] = 0;
            } else if grid[row][right_col] == 'E' {
                right_sums[row][right_col] = if right_col + 1 == num_cols {
                    0
                } else {
                    right_sums[row][right_col + 1]
                } + 1;
            } else {
                right_sums[row][right_col] = if right_col + 1 == num_cols {
                    0
                } else {
                    right_sums[row][right_col + 1]
                };
            }
        }
    }
    let mut up_sums = vec![vec![0; num_cols]; num_rows];
    let mut down_sums = vec![vec![0; num_cols]; num_rows];
    for col in 0..num_cols {
        for row in 0..num_rows {
            if grid[row][col] == 'W' {
                up_sums[row][col] = 0;
            } else if grid[row][col] == 'E' {
                up_sums[row][col] = if row as isize - 1 < 0 {
                    0
                } else {
                    up_sums[row - 1][col]
                } + 1;
            } else {
                up_sums[row][col] = if row as isize - 1 < 0 {
                    0
                } else {
                    up_sums[row - 1][col]
                };
            }
            let down_row = num_rows - row - 1;
            if grid[down_row][col] == 'W' {
                down_sums[down_row][col] = 0;
            } else if grid[down_row][col] == 'E' {
                down_sums[down_row][col] = if down_row + 1 == num_rows {
                    0
                } else {
                    down_sums[down_row + 1][col]
                } + 1;
            } else {
                down_sums[down_row][col] = if down_row + 1 == num_rows {
                    0
                } else {
                    down_sums[down_row + 1][col]
                };
            }
        }
    }
    for row in 0..num_rows {
        for col in 0..num_cols {
            if grid[row][col] == '0' {
                let left = if col as isize - 1 < 0 {
                    0
                } else {
                    left_sums[row][col - 1]
                };
                let right = if col + 1 == num_cols {
                    0
                } else {
                    right_sums[row][col + 1]
                };
                let up = if row as isize - 1 < 0 {
                    0
                } else {
                    up_sums[row - 1][col]
                };
                let down = if row + 1 == num_rows {
                    0
                } else {
                    down_sums[row + 1][col]
                };
                let count = left + right + up + down;
                answer = answer.max(count);
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        max_killed_enemies(vec![
            vec!['0', 'E', '0', '0'],
            vec!['E', '0', 'W', 'E'],
            vec!['0', 'E', '0', '0']
        ])
    ); // 3
    println!(
        "{}",
        max_killed_enemies(vec![
            vec!['W', 'W', 'W'],
            vec!['0', '0', '0'],
            vec!['E', 'E', 'E']
        ])
    ); // 1
    println!(
        "{}",
        max_killed_enemies(vec![vec![
            '0', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'W'
        ]])
    ); // 10
}
