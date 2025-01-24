use std::collections::HashMap;

// https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips-ii/description/
pub fn remove_ones(grid: Vec<Vec<i32>>) -> i32 {
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    let mut rows: HashMap<usize, Vec<(usize, usize)>> = HashMap::new();
    let mut cols: HashMap<usize, Vec<(usize, usize)>> = HashMap::new();
    for row in 0..num_rows {
        for col in 0..num_cols {
            rows.entry(row).or_insert(vec![]).push((row, col));
            cols.entry(col).or_insert(vec![]).push((row, col));
        }
    }
    0
}

fn main() {
    println!(
        "{}",
        remove_ones(vec![vec![1, 1, 1], vec![1, 1, 1], vec![0, 1, 0]])
    ); // 2
    println!(
        "{}",
        remove_ones(vec![vec![0, 1, 0], vec![1, 0, 1], vec![0, 1, 0]])
    ); // 2
    println!("{}", remove_ones(vec![vec![0, 0], vec![0, 0]])); // 0
}
