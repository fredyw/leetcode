use std::collections::HashSet;

// https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips-ii/description/
pub fn remove_ones(grid: Vec<Vec<i32>>) -> i32 {
    fn remove_ones(
        grid: &Vec<Vec<i32>>,
        changed_rows: &mut HashSet<usize>,
        changed_cols: &mut HashSet<usize>,
    ) -> i32 {
        let num_rows = grid.len();
        let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
        if changed_rows.len() == num_rows && changed_cols.len() == num_cols {
            return 0;
        }
        let mut min = i32::MAX;
        for row in 0..num_rows {
            for col in 0..num_cols {
                if grid[row][col] == 0 {
                    continue;
                }
                if grid[row][col] == 1 && changed_rows.contains(&row) && changed_cols.contains(&col)
                {
                    continue;
                }
                changed_rows.insert(row);
                changed_cols.insert(col);
                min = min.min(remove_ones(grid, changed_rows, changed_cols) + 1);
                changed_rows.remove(&row);
                changed_cols.remove(&col);
            }
        }
        min
    }

    remove_ones(&grid, &mut HashSet::new(), &mut HashSet::new())
}

fn main() {
    println!(
        "{}",
        remove_ones(vec![vec![1, 1, 1], vec![1, 1, 1], vec![0, 1, 0]])
    ); // 2
       // println!(
       //     "{}",
       //     remove_ones(vec![vec![0, 1, 0], vec![1, 0, 1], vec![0, 1, 0]])
       // ); // 2
       // println!("{}", remove_ones(vec![vec![0, 0], vec![0, 0]])); // 0
}
