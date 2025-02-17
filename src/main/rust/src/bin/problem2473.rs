use std::cmp::Reverse;
use std::collections::{BinaryHeap, HashMap};

// https://leetcode.com/problems/minimum-cost-to-buy-apples/description/
pub fn min_cost(n: i32, roads: Vec<Vec<i32>>, apple_cost: Vec<i32>, k: i32) -> Vec<i64> {
    fn build_graph(roads: &Vec<Vec<i32>>) -> HashMap<i32, Vec<(i32, i64)>> {
        let mut graph = HashMap::new();
        for road in roads.iter() {
            let a = road[0] - 1;
            let b = road[1] - 1;
            let cost = road[2] as i64;
            graph.entry(a).or_insert(vec![]).push((b, cost));
            graph.entry(b).or_insert(vec![]).push((a, cost));
        }
        graph
    }

    fn shortest_path(
        graph: &HashMap<i32, Vec<(i32, i64)>>,
        apple_cost: &Vec<i32>,
        k: i64,
        source: i32,
    ) -> i64 {
        let mut shortest_path: HashMap<i32, Option<i64>> = HashMap::new();
        shortest_path.insert(source, Some(0));
        let mut heap: BinaryHeap<Reverse<(i64, i32)>> = BinaryHeap::new();
        heap.push(Reverse((0, source)));
        let mut min_cost = i64::MAX;
        while !heap.is_empty() {
            if let Some(e) = heap.pop() {
                let (current_cost, from) = e.0;
                min_cost = min_cost.min(apple_cost[from as usize] as i64 + (k + 1) * current_cost);
                for (to, cost) in graph.get(&from).unwrap_or(&vec![]) {
                    let from_cost = shortest_path.get(&from).unwrap().unwrap();
                    let to_cost = shortest_path.get(to).unwrap_or(&None).unwrap_or(i64::MAX);
                    if to_cost > from_cost + cost {
                        let new_cost = from_cost + cost;
                        shortest_path.insert(*to, Some(new_cost));
                        heap.push(Reverse((new_cost, *to)));
                    }
                }
            }
        }
        min_cost
    }

    let mut answer: Vec<i64> = vec![];
    let graph = build_graph(&roads);
    for i in 0..n {
        answer.push(shortest_path(&graph, &apple_cost, k as i64, i));
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
