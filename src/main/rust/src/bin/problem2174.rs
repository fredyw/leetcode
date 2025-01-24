// https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips-ii/description/
pub fn remove_ones(grid: Vec<Vec<i32>>) -> i32 {
    fn remove_ones(
        grid: &Vec<Vec<i32>>,
        changed_rows: &mut Vec<bool>,
        changed_cols: &mut Vec<bool>,
    ) -> i32 {
        let num_rows = grid.len();
        let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
        let mut min = i32::MAX;
        for row in 0..num_rows {
            for col in 0..num_cols {
                if grid[row][col] == 0 {
                    continue;
                }
                if grid[row][col] == 1 && (changed_rows[row] || changed_cols[col]) {
                    continue;
                }
                changed_rows[row] = true;
                changed_cols[col] = true;
                min = min.min(remove_ones(grid, changed_rows, changed_cols) + 1);
                changed_rows[row] = false;
                changed_cols[col] = false;
            }
        }
        if min == i32::MAX {
            0
        } else {
            min
        }
    }

    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    remove_ones(
        &grid,
        &mut vec![false; num_rows],
        &mut vec![false; num_cols],
    )
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
