// https://leetcode.com/problems/most-profitable-path-in-a-tree/
pub fn most_profitable_path(edges: Vec<Vec<i32>>, bob: i32, amount: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        most_profitable_path(
            vec![vec![0, 1], vec![1, 2], vec![1, 3], vec![3, 4]],
            3,
            vec![-2, 4, 2, -4, 6]
        )
    ); // 6
    println!(
        "{}",
        most_profitable_path(vec![vec![0, 1]], 1, vec![-7280, 2350])
    ); // -7280
}
