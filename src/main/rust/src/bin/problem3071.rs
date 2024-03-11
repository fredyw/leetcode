// https://leetcode.com/problems/minimum-operations-to-write-the-letter-y-on-a-grid/description/
pub fn minimum_operations_to_write_y(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        minimum_operations_to_write_y(vec![vec![1, 2, 2], vec![1, 1, 0], vec![0, 1, 0]])
    ); // 3
    println!(
        "{}",
        minimum_operations_to_write_y(vec![
            vec![0, 1, 0, 1, 0],
            vec![2, 1, 0, 1, 2],
            vec![2, 2, 2, 0, 1],
            vec![2, 2, 2, 2, 2],
            vec![2, 1, 2, 2, 2]
        ])
    ); // 12
}
