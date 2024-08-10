// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
pub fn count_components(n: i32, edges: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        count_components(5, vec![vec![0, 1], vec![1, 2], vec![3, 4]])
    ); // 2
    println!(
        "{}",
        count_components(5, vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![3, 4]])
    ); // 1
}
