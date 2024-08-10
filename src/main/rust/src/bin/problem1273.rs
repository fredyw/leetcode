// https://leetcode.com/problems/delete-tree-nodes/description/
pub fn delete_tree_nodes(nodes: i32, parent: Vec<i32>, value: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        delete_tree_nodes(7, vec![-1, 0, 0, 1, 2, 2, 2], vec![1, -2, 4, 0, -2, -1, -1])
    ); // 2
    println!(
        "{}",
        delete_tree_nodes(7, vec![-1, 0, 0, 1, 2, 2, 2], vec![1, -2, 4, 0, -2, -1, -2])
    ); // 6
}
