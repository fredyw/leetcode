// https://leetcode.com/problems/sparse-matrix-multiplication/
pub fn multiply(mat1: Vec<Vec<i32>>, mat2: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    todo!()
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
}
