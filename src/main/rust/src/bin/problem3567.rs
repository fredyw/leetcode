// https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/description/
pub fn min_abs_diff(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!("{:?}", min_abs_diff(vec![vec![1, 8], vec![3, -2]], 2)); // [[2]]
    println!("{:?}", min_abs_diff(vec![vec![3, -1]], 1)); // [[0,0]]
    println!("{:?}", min_abs_diff(vec![vec![1, -2, 3], vec![2, 3, 5]], 2)); // [[1,2]]
}
