// https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
pub fn ones_minus_zeros(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    let max_rows = grid.len();
    let max_cols = if max_rows > 0 { grid[0].len() } else { 0 };
    let mut rows: Vec<i32> = vec![0; max_rows];
    let mut cols: Vec<i32> = vec![0; max_cols];
    for row in 0..max_rows {
        for col in 0..max_cols {
            rows[row] += grid[row][col];
            cols[col] += grid[row][col];
        }
    }

    let mut answer = vec![vec![0; max_cols]; max_rows];
    for row in 0..max_rows {
        for col in 0..max_cols {
            let ones_row = rows[row];
            let zeros_row = max_rows as i32 - ones_row;
            let ones_col = cols[col];
            let zeros_col = max_cols as i32 - ones_col;
            answer[row][col] = ones_row + ones_col - zeros_row - zeros_col;
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        ones_minus_zeros(vec![vec![0, 1, 1], vec![1, 0, 1], vec![0, 0, 1]])
    ); // [[0,0,4],[0,0,4],[-2,-2,2]]
    println!("{:?}", ones_minus_zeros(vec![vec![1, 1, 1], vec![1, 1, 1]])); // [[5,5,5],[5,5,5]]
}
