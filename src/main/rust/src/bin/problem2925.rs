// https://leetcode.com/problems/maximum-score-after-applying-operations-on-a-tree/
pub fn maximum_score_after_operations(edges: Vec<Vec<i32>>, values: Vec<i32>) -> i64 {
    fn dfs(tree: &Vec<Vec<usize>>, values: &Vec<i32>, root: usize, score: i64, sum: i64) -> i64 {
        if tree[root].is_empty() {
            return if sum > 0 { score } else { 0 };
        }
        for child in tree[root].iter() {}
        0
    }

    let mut tree: Vec<Vec<usize>> = vec![vec![]; values.len()];
    for edge in edges.into_iter() {
        let from = edge[0] as usize;
        let to = edge[1] as usize;
        tree[from].push(to);
    }
    dfs(&tree, &values, 0, 0, 0)
}

fn main() {
    println!(
        "{}",
        maximum_score_after_operations(
            vec![vec![0, 1], vec![0, 2], vec![0, 3], vec![2, 4], vec![4, 5]],
            vec![5, 2, 5, 2, 1, 1]
        )
    ); // 11
       // println!(
       //     "{}",
       //     maximum_score_after_operations(
       //         vec![
       //             vec![0, 1],
       //             vec![0, 2],
       //             vec![1, 3],
       //             vec![1, 4],
       //             vec![2, 5],
       //             vec![2, 6]
       //         ],
       //         vec![20, 10, 9, 7, 4, 3, 5]
       //     )
       // ); // 40
}
