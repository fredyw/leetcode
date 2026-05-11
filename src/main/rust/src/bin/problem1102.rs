// https://leetcode.com/problems/path-with-maximum-minimum-value/description/
pub fn maximum_minimum_path(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        maximum_minimum_path(vec![vec![5, 4, 5], vec![1, 2, 6], vec![7, 4, 6]])
    ); // 4
    println!(
        "{}",
        maximum_minimum_path(vec![vec![2, 2, 1, 2, 2, 2], vec![1, 2, 2, 2, 1, 2]])
    ); // 2
    println!(
        "{}",
        maximum_minimum_path(vec![
            vec![3, 4, 6, 3, 4],
            vec![0, 2, 1, 1, 7],
            vec![8, 8, 3, 2, 7],
            vec![3, 2, 4, 9, 8],
            vec![4, 1, 2, 0, 0],
            vec![4, 6, 5, 4, 3]
        ])
    ); // 3
}
