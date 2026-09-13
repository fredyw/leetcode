// https://leetcode.com/problems/cyclically-shift-rows-and-columns/description/
pub fn cyclic_shift(
    n: i32,
    grid: Vec<Vec<i32>>,
    row_shift: Vec<i32>,
    col_shift: Vec<i32>,
) -> Vec<Vec<i32>> {
    todo!()
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
