// https://leetcode.com/problems/modify-the-matrix/description/
pub fn modified_matrix(matrix: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        modified_matrix(vec![vec![1, 2, -1], vec![4, -1, 6], vec![7, 8, 9]])
    ); // [[1,2,9],[4,8,6],[7,8,9]]
    println!("{:?}", modified_matrix(vec![vec![3, -1], vec![5, 2]])); // [[3,2],[5,2]]
}
