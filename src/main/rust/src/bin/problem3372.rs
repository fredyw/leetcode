// https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/description/
pub fn max_target_nodes(edges1: Vec<Vec<i32>>, edges2: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        max_target_nodes(
            vec![vec![0, 1], vec![0, 2], vec![2, 3], vec![2, 4]],
            vec![
                vec![0, 1],
                vec![0, 2],
                vec![0, 3],
                vec![2, 7],
                vec![1, 4],
                vec![4, 5],
                vec![4, 6]
            ],
            2
        )
    ); // [9,7,9,8,8]
    println!(
        "{:?}",
        max_target_nodes(
            vec![vec![0, 1], vec![0, 2], vec![0, 3], vec![0, 4]],
            vec![vec![0, 1], vec![1, 2], vec![2, 3]],
            1
        )
    ); // [9,7,9,8,8]
}
