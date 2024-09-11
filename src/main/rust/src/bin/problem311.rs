// https://leetcode.com/problems/sparse-matrix-multiplication/
pub fn multiply(mat1: Vec<Vec<i32>>, mat2: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    let mut sparse_mat2: Vec<Vec<i32>> = vec![vec![]; mat2[0].len()];
    for col in 0..mat2[0].len() {
        for row in 0..mat2.len() {
            if mat2[row][col] != 0 {
                sparse_mat2[col].push(mat2[row][col]);
            }
        }
    }
    let mut answer = vec![vec![0; mat2[0].len()]; mat1.len()];
    answer
}

fn main() {
    println!(
        "{:?}",
        multiply(
            vec![vec![1, 0, 0], vec![-1, 0, 3]],
            vec![vec![7, 0, 0], vec![0, 0, 0], vec![0, 0, 1]]
        )
    ); // [[7,0,0],[-7,0,3]]
    println!("{:?}", multiply(vec![vec![0]], vec![vec![0]])); // [[0]]
    println!(
        "{:?}",
        multiply(vec![vec![1, -5]], vec![vec![12], vec![-1]])
    ); // [[17]]
}
