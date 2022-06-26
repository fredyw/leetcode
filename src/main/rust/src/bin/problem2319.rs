use std::collections::HashSet;

// https://leetcode.com/problems/check-if-matrix-is-x-matrix/
pub fn check_x_matrix(grid: Vec<Vec<i32>>) -> bool {
    let n = grid.len();
    let mut set: HashSet<(i32, i32)> = HashSet::new();
    let mut row: i32 = 0;
    let mut col: i32 = 0;
    while row < n as i32 {
        if grid[row as usize][col as usize] == 0 {
            return false;
        }
        set.insert((row, col));
        row += 1;
        col += 1;
    }
    let mut row: i32 = 0;
    let mut col: i32 = n as i32 - 1;
    while row < n as i32 {
        if grid[row as usize][col as usize] == 0 {
            return false;
        }
        set.insert((row, col));
        row += 1;
        col -= 1;
    }
    let mut row: i32 = 0;
    while row < n as i32 {
        let mut col: i32 = 0;
        while col < n as i32 {
            if !set.contains(&(row, col)) {
                if grid[row as usize][col as usize] != 0 {
                    return false;
                }
            }
            col += 1;
        }
        row += 1;
    }
    true
}

fn main() {
    println!(
        "{}",
        check_x_matrix(vec![
            vec![2, 0, 0, 1],
            vec![0, 3, 1, 0],
            vec![0, 5, 2, 0],
            vec![4, 0, 0, 2]
        ])
    ); // true
    println!(
        "{}",
        check_x_matrix(vec![vec![5, 7, 0], vec![0, 3, 1], vec![0, 5, 0]])
    ); // false
}
