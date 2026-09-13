// https://leetcode.com/problems/cyclically-shift-rows-and-columns/description/
pub fn cyclic_shift(
    n: i32,
    mut grid: Vec<Vec<i32>>,
    row_shift: Vec<i32>,
    col_shift: Vec<i32>,
) -> Vec<Vec<i32>> {
    let n = n as usize;
    for (row, &shift) in row_shift.iter().enumerate() {
        let cloned_rows = (&grid[row]).clone();
        for col in 0..n {
            let col = col;
            grid[row][col] = cloned_rows[(col + shift as usize) % n];
        }
    }
    for (col, &shift) in col_shift.iter().enumerate() {
        let mut cloned_rows: Vec<i32> = vec![];
        for row in 0..n {
            cloned_rows.push(grid[row][col]);
        }
        for row in 0..n {
            grid[row][col] = cloned_rows[(row + shift as usize) % n];
        }
    }
    grid
}

fn main() {
    println!(
        "{:?}",
        cyclic_shift(2, vec![vec![1, 2], vec![3, 4]], vec![1, 0], vec![0, 1])
    ); // [[2,4],[3,1]]
    println!(
        "{:?}",
        cyclic_shift(
            3,
            vec![vec![1, 2, 3], vec![4, 5, 6], vec![7, 8, 9]],
            vec![1, 2, 0],
            vec![2, 2, 1]
        )
    ); // [[7,8,5],[2,3,9],[6,4,1]]
}
