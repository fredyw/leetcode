// https://leetcode.com/problems/cherry-pickup-ii/
pub fn cherry_pickup(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        cherry_pickup(vec![
            vec![3, 1, 1],
            vec![2, 5, 1],
            vec![1, 5, 5],
            vec![2, 1, 1]
        ])
    ); // 24
    println!(
        "{}",
        cherry_pickup(vec![
            vec![1, 0, 0, 0, 0, 0, 1],
            vec![2, 0, 0, 0, 0, 3, 0],
            vec![2, 0, 9, 0, 0, 0, 0],
            vec![0, 3, 0, 5, 4, 0, 0],
            vec![1, 0, 2, 3, 0, 0, 6]
        ])
    ); // 28
}
