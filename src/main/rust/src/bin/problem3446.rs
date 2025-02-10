// https://leetcode.com/problems/sort-matrix-by-diagonals/description/
pub fn sort_matrix(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        sort_matrix(vec![vec![1, 7, 3], vec![9, 8, 2], vec![4, 5, 6]])
    ); // [[8,2,3],[9,6,7],[4,5,1]]
    println!("{:?}", sort_matrix(vec![vec![0, 1], vec![1, 2]])); // [[2,1],[1,0]]
}
