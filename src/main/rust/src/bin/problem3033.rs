// https://leetcode.com/problems/modify-the-matrix/description/
pub fn modified_matrix(mut matrix: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    let max_row = matrix.len();
    let max_col = matrix[0].len();
    for col in 0..max_col {
        let mut max = 0;
        let mut row_cols: Vec<(usize, usize)> = vec![];
        for row in 0..max_row {
            if matrix[row][col] == -1 {
                row_cols.push((row, col));
            }
            max = max.max(matrix[row][col]);
        }
        for (row, col) in row_cols.into_iter() {
            matrix[row][col] = max;
        }
    }
    matrix
}

fn main() {
    println!(
        "{:?}",
        modified_matrix(vec![vec![1, 2, -1], vec![4, -1, 6], vec![7, 8, 9]])
    ); // [[1,2,9],[4,8,6],[7,8,9]]
    println!("{:?}", modified_matrix(vec![vec![3, -1], vec![5, 2]])); // [[3,2],[5,2]]
}
