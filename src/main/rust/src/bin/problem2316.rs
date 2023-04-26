// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
pub fn count_pairs(n: i32, edges: Vec<Vec<i32>>) -> i64 {
    todo!()
}

fn main() {
    println!(
        "{}",
        count_pairs(3, vec![vec![0, 1], vec![0, 2], vec![1, 2]])
    ); // 0
    println!(
        "{}",
        count_pairs(
            7,
            vec![vec![0, 2], vec![0, 5], vec![2, 4], vec![1, 6], vec![5, 4]]
        )
    ); // 14
}
