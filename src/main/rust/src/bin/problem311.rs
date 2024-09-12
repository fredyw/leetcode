use std::collections::HashSet;

// https://leetcode.com/problems/sparse-matrix-multiplication/
pub fn multiply(mat1: Vec<Vec<i32>>, mat2: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    let mut sparse_mat1: Vec<HashSet<usize>> = vec![HashSet::new(); mat1.len()];
    for row in 0..mat1.len() {
        for col in 0..mat1[row].len() {
            if mat1[row][col] != 0 {
                sparse_mat1[row].insert(col);
            }
        }
    }
    let mut sparse_mat2: Vec<HashSet<usize>> = vec![HashSet::new(); mat2[0].len()];
    for col in 0..mat2[0].len() {
        for row in 0..mat2.len() {
            if mat2[row][col] != 0 {
                sparse_mat2[col].insert(row);
            }
        }
    }
    let mut answer = vec![vec![0; mat2[0].len()]; mat1.len()];
    for row in 0..sparse_mat1.len() {
        let cols = &sparse_mat1[row];
        for col in 0..sparse_mat2.len() {
            let rows = &sparse_mat2[col];
            let mut dot_product = 0;
            for c in cols.iter() {
                if rows.contains(c) {
                    dot_product += mat1[row][*c] * mat2[*c][col];
                }
            }
            answer[row][col] = dot_product;
        }
    }
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
