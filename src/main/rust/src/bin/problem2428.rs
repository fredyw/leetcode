// https://leetcode.com/problems/maximum-sum-of-an-hourglass/
pub fn max_sum(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        max_sum(vec![
            vec![6, 2, 1, 3],
            vec![4, 2, 1, 5],
            vec![9, 2, 8, 7],
            vec![4, 1, 2, 9]
        ])
    ); // 30
    println!(
        "{}",
        max_sum(vec![vec![1, 2, 3], vec![4, 5, 6], vec![7, 8, 9]])
    ); // 35
}
