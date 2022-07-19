// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
pub fn num_submatrix_sum_target(matrix: Vec<Vec<i32>>, target: i32) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        num_submatrix_sum_target(vec![vec![0, 1, 0], vec![1, 1, 1], vec![0, 1, 0]], 0)
    ); // 4
    println!(
        "{}",
        num_submatrix_sum_target(vec![vec![1, -1], vec![-1, 1]], 0)
    ); // 5
    println!("{}", num_submatrix_sum_target(vec![vec![904]], 0)); // 0
}
