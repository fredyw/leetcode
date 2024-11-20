// https://leetcode.com/problems/bomb-enemy/description/
pub fn max_killed_enemies(grid: Vec<Vec<char>>) -> i32 {
    let mut answer = 0;
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    let mut left_sums = vec![vec![0; num_cols]; num_rows];
    let mut right_sums = vec![vec![0; num_cols]; num_rows];
    for i in 0..num_rows {
        for j in 0..num_cols {
            if grid[i][j] == 'W' {
                left_sums[i][j] = 0;
            } else if grid[i][j] == 'E' {
                left_sums[i][j] = if j as isize - 1 < 0 {
                    0
                } else {
                    left_sums[i][j - 1]
                } + 1;
            } else {
                left_sums[i][j] = if j as isize - 1 < 0 {
                    0
                } else {
                    left_sums[i][j - 1]
                };
            }
            let k = num_cols - j - 1;
            if grid[i][k] == 'W' {
                right_sums[i][k] = 0;
            } else if grid[i][k] == 'E' {
                right_sums[i][k] = if k + 1 == num_cols {
                    0
                } else {
                    right_sums[i][k + 1]
                } + 1;
            } else {
                right_sums[i][k] = if k + 1 == num_cols {
                    0
                } else {
                    right_sums[i][k + 1]
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
                let count = left + right;
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
