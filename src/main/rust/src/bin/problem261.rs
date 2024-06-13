// https://leetcode.com/problems/graph-valid-tree/description/
pub fn valid_tree(n: i32, edges: Vec<Vec<i32>>) -> bool {
    todo!()
}

fn main() {
    println!(
        "{}",
        valid_tree(5, vec![vec![0, 1], vec![0, 2], vec![0, 3], vec![1, 4]])
    ); // true
    println!(
        "{}",
        valid_tree(
            5,
            vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![1, 3], vec![1, 4]]
        )
    ); // true
}
