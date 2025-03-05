// https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/description/
pub fn max_moves(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        max_moves(vec![
            vec![2, 4, 3, 5],
            vec![5, 4, 9, 3],
            vec![3, 4, 2, 11],
            vec![10, 9, 13, 15]
        ])
    ); // 3
    println!(
        "{}",
        max_moves(vec![vec![3, 2, 4], vec![2, 1, 9], vec![1, 1, 7]])
    ); // 0
    println!("{}", max_moves(vec![vec![2, 4], vec![5, 4],])); // 1
    println!(
        "{}",
        max_moves(vec![
            vec![8, 4, 3, 5],
            vec![5, 4, 9, 3],
            vec![3, 4, 2, 11],
            vec![10, 9, 13, 15]
        ])
    ); // 3
}
