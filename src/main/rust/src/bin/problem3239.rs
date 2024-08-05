// https://leetcode.com/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i/description/
pub fn min_flips(grid: Vec<Vec<i32>>) -> i32 {
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    let mut row_flips = 0;
    for row in 0..num_rows {
        let mut i = 0;
        let mut j = num_cols - 1;
        while i < j {
            if grid[row][i] != grid[row][j] {
                row_flips += 1;
            }
            i += 1;
            j -= 1;
        }
    }
    let mut col_flips = 0;
    for col in 0..num_cols {
        let mut i = 0;
        let mut j = num_rows - 1;
        while i < j {
            if grid[i][col] != grid[j][col] {
                col_flips += 1;
            }
            i += 1;
            j -= 1;
        }
    }
    row_flips.min(col_flips)
}

fn main() {
    println!(
        "{}",
        min_flips(vec![vec![1, 0, 0], vec![0, 0, 0], vec![0, 0, 1]])
    ); // 2
    println!("{}", min_flips(vec![vec![0, 1], vec![0, 1], vec![0, 0]])); // 1
    println!("{}", min_flips(vec![vec![1], vec![0]])); // 0
}
