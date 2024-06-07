// https://leetcode.com/problems/find-the-safest-path-in-a-grid/description/
pub fn maximum_safeness_factor(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        maximum_safeness_factor(vec![vec![1, 0, 0], vec![0, 0, 0], vec![0, 0, 1]])
    ); // 0
    println!(
        "{}",
        maximum_safeness_factor(vec![vec![0, 0, 1], vec![0, 0, 0], vec![0, 0, 0]])
    ); // 2
    println!(
        "{}",
        maximum_safeness_factor(vec![
            vec![0, 0, 0, 1],
            vec![0, 0, 0, 0],
            vec![0, 0, 0, 0],
            vec![1, 0, 0, 0]
        ])
    ); // 2
}
