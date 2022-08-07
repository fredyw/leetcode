// https://leetcode.com/problems/reachable-nodes-with-restrictions/
pub fn reachable_nodes(n: i32, edges: Vec<Vec<i32>>, restricted: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        reachable_nodes(
            7,
            vec![
                vec![0, 1],
                vec![1, 2],
                vec![3, 1],
                vec![4, 0],
                vec![0, 5],
                vec![5, 6]
            ],
            vec![4, 5]
        )
    ); // 4
    println!(
        "{}",
        reachable_nodes(
            7,
            vec![
                vec![0, 1],
                vec![0, 2],
                vec![0, 5],
                vec![0, 4],
                vec![3, 2],
                vec![6, 5]
            ],
            vec![4, 2, 1]
        )
    ); // 3
}
