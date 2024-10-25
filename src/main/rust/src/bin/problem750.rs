// https://leetcode.com/problems/number-of-corner-rectangles/description/
pub fn count_corner_rectangles(grid: Vec<Vec<i32>>) -> i32 {
    let mut answer = 0;
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    for row1 in 0..num_rows {
        for col1 in 0..num_cols {
            if grid[row1][col1] != 1 {
                continue;
            }
            for row2 in row1 + 1..num_rows {
                if grid[row2][col1] != 1 {
                    continue;
                }
                for col2 in col1 + 1..num_cols {
                    if grid[row1][col2] == 1 && grid[row2][col2] == 1 {
                        answer += 1;
                    }
                }
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        count_corner_rectangles(vec![
            vec![1, 0, 0, 1, 0],
            vec![0, 0, 1, 0, 1],
            vec![0, 0, 0, 1, 0],
            vec![1, 0, 1, 0, 1]
        ])
    ); // 1
    println!(
        "{}",
        count_corner_rectangles(vec![vec![1, 1, 1], vec![1, 1, 1], vec![1, 1, 1]])
    ); // 9
    println!("{}", count_corner_rectangles(vec![vec![1, 1, 1, 1]])); // 0
}
