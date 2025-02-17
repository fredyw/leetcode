// https://leetcode.com/problems/minimum-cost-to-buy-apples/description/
pub fn min_cost(n: i32, roads: Vec<Vec<i32>>, apple_cost: Vec<i32>, k: i32) -> Vec<i64> {
    let mut graph: Vec<Vec<i32>> = vec![vec![0; n as usize]; n as usize];
    for road in roads.iter() {
        let a = road[0] - 1;
        let b = road[1] - 1;
        let cost = road[2];
        graph[a as usize][b as usize] = cost;
        graph[b as usize][a as usize] = cost;
    }

    for i in 0..n as usize {
        for j in 0..n as usize {
            if graph[i][j] == 0 && i != j {
                graph[i][j] = i32::MAX;
            }
        }
    }

    for k in 0..n as usize {
        for i in 0..n as usize {
            for j in 0..n as usize {
                graph[i][j] = graph[i][j].min(graph[i][k].saturating_add(graph[k][j]));
            }
        }
    }

    let mut answer = vec![0; n as usize];
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
       // println!(
       //     "{:?}",
       //     min_cost(
       //         3,
       //         vec![vec![1, 2, 5], vec![2, 3, 1], vec![3, 1, 2]],
       //         vec![2, 3, 1],
       //         3
       //     )
       // ); // [2,3,1]
}
