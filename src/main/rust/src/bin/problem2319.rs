// https://leetcode.com/problems/check-if-matrix-is-x-matrix/
pub fn check_x_matrix(grid: Vec<Vec<i32>>) -> bool {
    todo!()
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
    ); // true
}
