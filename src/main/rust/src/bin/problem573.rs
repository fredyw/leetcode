// https://leetcode.com/problems/squirrel-simulation/description/
pub fn min_distance(
    height: i32,
    width: i32,
    tree: Vec<i32>,
    squirrel: Vec<i32>,
    nuts: Vec<Vec<i32>>,
) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        min_distance(5, 7, vec![2, 2], vec![4, 4], vec![vec![3, 0], vec![2, 5]])
    ); // 12
    println!(
        "{}",
        min_distance(1, 3, vec![0, 1], vec![0, 0], vec![vec![0, 2]])
    ); // 3
}
