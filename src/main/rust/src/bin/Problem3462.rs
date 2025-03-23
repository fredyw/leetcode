// https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/description/
pub fn max_sum(grid: Vec<Vec<i32>>, limits: Vec<i32>, k: i32) -> i64 {
    todo!()
}

fn main() {
    println!("{}", max_sum(vec![vec![1, 2], vec![3, 4]], vec![1, 2], 2)); // 7
    println!(
        "{}",
        max_sum(vec![vec![5, 3, 7], vec![8, 2, 6]], vec![2, 2], 3)
    ); // 21
    println!(
        "{}",
        max_sum(
            vec![vec![7, 5, 3], vec![8, 6, 2], vec![9, 5, 4], vec![10, 9, 7]],
            vec![2, 1, 3, 2],
            6
        )
    ); // 48
}
