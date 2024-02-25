// https://leetcode.com/problems/maximum-score-after-applying-operations-on-a-tree/
pub fn maximum_score_after_operations(edges: Vec<Vec<i32>>, values: Vec<i32>) -> i64 {
    todo!()
}

fn main() {
    println!(
        "{}",
        maximum_score_after_operations(
            vec![vec![0, 1], vec![0, 2], vec![0, 3], vec![2, 4], vec![4, 5]],
            vec![5, 2, 5, 2, 1, 1]
        )
    ); // 11
    println!(
        "{}",
        maximum_score_after_operations(
            vec![
                vec![0, 1],
                vec![0, 2],
                vec![1, 3],
                vec![1, 4],
                vec![2, 5],
                vec![2, 6]
            ],
            vec![20, 10, 9, 7, 4, 3, 5]
        )
    ); // 40
}
