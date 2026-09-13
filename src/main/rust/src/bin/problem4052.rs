// https://leetcode.com/problems/cyclically-shift-rows-and-columns/description/
pub fn cyclic_shift(
    n: i32,
    mut grid: Vec<Vec<i32>>,
    row_shift: Vec<i32>,
    col_shift: Vec<i32>,
) -> Vec<Vec<i32>> {
    for (i, &shift) in row_shift.iter().enumerate() {
        let cloned_rows = (&grid[i]).clone();
        let mut_rows = &mut grid[i];
        for col in 0..n {
            let col = col as usize;
            mut_rows[col] = cloned_rows[(col + shift as usize) % n as usize];
        }
    }
    for (i, &shift) in col_shift.iter().enumerate() {}
    grid
}

fn main() {
    println!(
        "{:?}",
        cyclic_shift(3, vec![vec![1, 2], vec![3, 4]], vec![1, 0], vec![0, 1])
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
