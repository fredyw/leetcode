// https://leetcode.com/problems/maximum-score-after-applying-operations-on-a-tree/
pub fn maximum_score_after_operations(edges: Vec<Vec<i32>>, values: Vec<i32>) -> i64 {
    fn dfs(tree: &Vec<Vec<usize>>, values: &Vec<i32>, root: usize) -> (i64, i64) {
        if tree[root].is_empty() {
            return (0, values[root] as i64);
        }
        let mut total_score = 0;
        let mut total_sum = 0;
        for child in tree[root].iter() {
            let (score, sum) = dfs(tree, values, *child);
            total_score += score;
            total_sum += sum;
        }
        let max_score = total_sum.max(total_score + values[root] as i64);
        return (max_score, values[root] as i64 + total_sum);
    }

    let mut tree: Vec<Vec<usize>> = vec![vec![]; values.len()];
    for edge in edges.into_iter() {
        let from = edge[0] as usize;
        let to = edge[1] as usize;
        tree[from].push(to);
    }
    let (score, sum) = dfs(&tree, &values, 0);
    sum.max(score)
}

fn main() {
    // println!(
    //     "{}",
    //     maximum_score_after_operations(
    //         vec![vec![0, 1], vec![0, 2], vec![0, 3], vec![2, 4], vec![4, 5]],
    //         vec![5, 2, 5, 2, 1, 1]
    //     )
    // ); // 11
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
    println!(
        "{}",
        maximum_score_after_operations(
            vec![
                vec![7, 0],
                vec![3, 1],
                vec![6, 2],
                vec![4, 3],
                vec![4, 5],
                vec![4, 6],
                vec![4, 7]
            ],
            vec![2, 16, 23, 17, 22, 21, 8, 6]
        )
    ); // 113
}
