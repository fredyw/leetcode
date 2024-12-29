// https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/
pub fn minimum_operations(mut grid: Vec<Vec<i32>>) -> i32 {
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    let mut answer = 0;
    for col in 0..num_cols {
        for row in 1..num_rows {
            let next = grid[row - 1][col] - grid[row][col] + 1;
            if next > 0 {
                grid[row][col] += next;
                answer += next;
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        minimum_operations(vec![vec![3, 2], vec![1, 3], vec![3, 4], vec![0, 1]])
    ); // 15
    println!(
        "{}",
        minimum_operations(vec![vec![3, 2, 1], vec![2, 1, 0], vec![1, 2, 3]])
    ); // 12
    println!("{}", minimum_operations(vec![vec![0], vec![50]])); // 0
    println!(
        "{}",
        minimum_operations(vec![vec![6, 3, 4], vec![9, 1, 3], vec![4, 6, 3]])
    ); // 14
}
