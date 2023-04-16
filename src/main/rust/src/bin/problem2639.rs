// https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/
pub fn find_column_width(grid: Vec<Vec<i32>>) -> Vec<i32> {
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    let mut answer = vec![0; num_cols];
    for col in 0..num_cols {
        let mut max_length = 0;
        for row in 0..num_rows {
            max_length = max_length.max(format!("{}", grid[row][col]).len() as i32);
        }
        answer[col] = max_length;
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        find_column_width(vec![vec![1], vec![22], vec![333]])
    ); // [3]
    println!(
        "{:?}",
        find_column_width(vec![vec![-15, 1, 3], vec![15, 7, 12], vec![5, 6, -2]])
    ); // [3,1,2]
}
