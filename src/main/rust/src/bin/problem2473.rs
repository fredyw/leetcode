// https://leetcode.com/problems/minimum-cost-to-buy-apples/description/
pub fn min_cost(n: i32, roads: Vec<Vec<i32>>, apple_cost: Vec<i32>, k: i32) -> Vec<i64> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        min_cost(
            4,
            vec![
                vec![1, 2, 4],
                vec![2, 3, 2],
                vec![2, 4, 5],
                vec![3, 4, 1],
                vec![1, 3, 4]
            ],
            vec![56, 42, 102, 301],
            2
        )
    ); // [54,42,48,51]
    println!(
        "{:?}",
        min_cost(
            3,
            vec![vec![1, 2, 5], vec![2, 3, 1], vec![3, 1, 2]],
            vec![2, 3, 1],
            3
        )
    ); // [2,3,1]
}
