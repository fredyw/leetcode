use std::cmp::Reverse;
use std::collections::{BinaryHeap, HashMap};

// https://leetcode.com/problems/minimum-cost-to-buy-apples/description/
pub fn min_cost(n: i32, roads: Vec<Vec<i32>>, apple_cost: Vec<i32>, k: i32) -> Vec<i64> {
    fn shortest_path(
        graph: &HashMap<char, Vec<(char, i32)>>,
        source: char,
    ) -> HashMap<char, Option<i32>> {
        let mut shortest_path: HashMap<char, Option<i32>> = HashMap::new();
        shortest_path.insert(source, Some(0));
        let mut heap: BinaryHeap<Reverse<(i32, char)>> = BinaryHeap::new();
        heap.push(Reverse((0, source)));
        while !heap.is_empty() {
            if let Some(e) = heap.pop() {
                let (_, from) = e.0;
                for (to, cost) in graph.get(&from).unwrap_or(&vec![]) {
                    let from_cost = shortest_path.get(&from).unwrap().unwrap();
                    let to_cost = shortest_path.get(to).unwrap_or(&None).unwrap_or(i32::MAX);
                    if to_cost > from_cost + cost {
                        let new_cost = from_cost + cost;
                        shortest_path.insert(*to, Some(new_cost));
                        heap.push(Reverse((new_cost, *to)));
                    }
                }
            }
        }
        shortest_path
    }

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
