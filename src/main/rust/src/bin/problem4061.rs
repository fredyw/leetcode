// https://leetcode.com/problems/minimum-queen-moves-to-reach-target/description/
pub fn min_queen_moves(source: Vec<i32>, target: Vec<i32>) -> i32 {
    if source == target {
        0
    } else if source[0] == target[0]
        || source[1] == target[1]
        || (source[0] - target[0]).abs() == (source[1] - target[1]).abs()
    {
        1
    } else {
        2
    }
}

fn main() {
    println!("{}", min_queen_moves(vec![8, 1], vec![1, 8])); // 1
    println!("{}", min_queen_moves(vec![4, 2], vec![1, 3])); // 2
    println!("{}", min_queen_moves(vec![1, 1], vec![1, 1])); // 0
}
