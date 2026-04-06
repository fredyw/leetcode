// https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/
pub fn number_of_submatrices(grid: Vec<Vec<char>>) -> i32 {
    let mut answer = 0;
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    let mut counts: Vec<Vec<(i32, i32)>> = vec![vec![(0, 0); num_cols]; num_rows];
    for row in 0..num_rows {
        let mut count_x = 0;
        let mut count_y = 0;
        for col in 0..num_cols {
            if grid[row][col] == 'X' {
                count_x += 1;
            } else if grid[row][col] == 'Y' {
                count_y += 1;
            }
            if row > 0 {
                counts[row][col].0 += counts[row - 1][col].0;
                counts[row][col].1 += counts[row - 1][col].1;
            }
            counts[row][col].0 += count_x;
            counts[row][col].1 += count_y;
            if counts[row][col].0 > 0 && counts[row][col].0 == counts[row][col].1 {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        number_of_submatrices(vec![vec!['X', 'Y', '.'], vec!['Y', '.', '.']])
    ); // 3
    println!(
        "{}",
        number_of_submatrices(vec![vec!['X', 'X'], vec!['X', 'Y']])
    ); // 0
    println!(
        "{}",
        number_of_submatrices(vec![vec!['.', '.'], vec!['.', '.']])
    ); // 0
    println!(
        "{}",
        number_of_submatrices(vec![vec!['X', 'X'], vec!['Y', 'Y']])
    ); // 2
}
