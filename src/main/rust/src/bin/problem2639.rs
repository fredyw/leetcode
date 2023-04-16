// https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/
pub fn find_column_width(grid: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        find_column_width(vec![vec![1], vec![22], vec![333]])
    ); // [3]
    println!(
        "{:?}",
        find_column_width(vec![vec![-15, 1, 3], vec![15, 7, 12], vec![5, 6, -2]])
    ); // [3,1,2]
}
