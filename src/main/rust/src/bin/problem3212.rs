// https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/
pub fn number_of_submatrices(grid: Vec<Vec<char>>) -> i32 {
    let mut answer = 0;
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    let mut count_x = 0;
    let mut count_y = 0;
    for row in 0..num_rows {
        if grid[row][0] == 'X' {
            count_x += 1;
        } else if grid[row][0] == 'Y' {
            count_y += 1;
        }
        if count_x > 0 && count_x == count_y {
            answer += 1;
        }
    }
    for col in 0..num_cols {
        if grid[0][col] == 'X' {
            count_x += 1;
        } else if grid[0][col] == 'Y' {
            count_y += 1;
        }
        if count_x > 0 && count_x == count_y {
            answer += 1;
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
