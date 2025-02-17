// https://leetcode.com/problems/minimum-cost-to-buy-apples/description/
pub fn min_cost(n: i32, roads: Vec<Vec<i32>>, apple_cost: Vec<i32>, k: i32) -> Vec<i64> {
    let mut answer: Vec<i64> = vec![i64::MAX; n as usize];
    let mut dp: Vec<Vec<i64>> = vec![vec![0; n as usize]; n as usize];
    for i in 0..n as usize {
        for j in 0..n as usize {
            if i == j {
                dp[i][j] = 0;
            } else {
                dp[i][j] = i64::MAX;
            }
        }
    }
    for road in roads.iter() {
        let from = road[0] as usize - 1;
        let to = road[1] as usize - 1;
        let cost = road[2];
        dp[from][to] = cost as i64;
        dp[to][from] = cost as i64;
        answer[from] =
            answer[from].min(dp[from][to] + apple_cost[to] as i64 + (k as i64 * dp[from][to]));
        answer[to] =
            answer[to].min(dp[to][from] + apple_cost[from] as i64 + (k as i64 * dp[to][from]));
    }
    for c in 0..n as usize {
        for a in 0..n as usize {
            for b in 0..n as usize {
                if dp[a][c] == i64::MAX || dp[c][b] == i64::MAX {
                    continue;
                }
                dp[a][b] = dp[a][b].min(dp[a][c] + dp[c][b]);
                answer[a] = answer[a].min(dp[a][b] + apple_cost[b] as i64 + (k as i64 * dp[a][b]));
            }
        }
    }
    answer
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
