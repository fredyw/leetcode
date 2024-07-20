// https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/description/
pub fn remove_ones(mut grid: Vec<Vec<i32>>) -> bool {
    let max_row = grid.len();
    let max_col = if max_row > 0 { grid[0].len() } else { 0 };
    for col in 0..max_col {
        if grid[0][col] == 1 {
            for row in 0..max_row {
                grid[row][col] = if grid[row][col] == 0 { 1 } else { 0 };
            }
        }
    }
    for row in 0..max_row {
        let mut sum = 0;
        for col in 0..max_col {
            sum += grid[row][col];
        }
        if sum != 0 && sum != max_col as i32 {
            return false;
        }
    }
    true
}

fn main() {
    println!(
        "{}",
        remove_ones(vec![vec![0, 1, 0], vec![1, 0, 1], vec![0, 1, 0]])
    ); // true
    println!(
        "{}",
        remove_ones(vec![vec![1, 1, 0], vec![0, 0, 0], vec![0, 0, 0]])
    ); // false
    println!("{}", remove_ones(vec![vec![0]])); // true
    println!(
        "{}",
        remove_ones(vec![vec![0, 1, 0], vec![1, 1, 1], vec![0, 1, 0]])
    ); // false
}
