use std::cmp::Reverse;
use std::collections::{BinaryHeap, HashMap};

// https://leetcode.com/problems/find-the-closest-marked-node/description/
pub fn minimum_distance(n: i32, edges: Vec<Vec<i32>>, s: i32, marked: Vec<i32>) -> i32 {
    fn build_graph(edges: &Vec<Vec<i32>>) -> HashMap<i32, Vec<(i32, i32)>> {
        let mut graph = HashMap::new();
        for edge in edges.iter() {
            let from = edge[0];
            let to = edge[1];
            let weight = edge[2];
            graph.entry(from).or_insert(vec![]).push((to, weight));
        }
        graph
    }

    fn shortest_path(
        graph: &HashMap<i32, Vec<(i32, i32)>>,
        source: i32,
    ) -> HashMap<i32, Option<i32>> {
        let mut shortest_path: HashMap<i32, Option<i32>> = HashMap::new();
        shortest_path.insert(source, Some(0));
        let mut heap: BinaryHeap<Reverse<(i32, i32)>> = BinaryHeap::new();
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

    let graph = build_graph(&edges);
    let shortest_path = shortest_path(&graph, s);
    let mut answer = i32::MAX;
    for m in marked {
        if let Some(n) = shortest_path.get(&m) {
            answer = answer.min(n.unwrap());
        }
    }
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    println!(
        "{}",
        minimum_distance(
            4,
            vec![vec![0, 1, 1], vec![1, 2, 3], vec![2, 3, 2], vec![0, 3, 4]],
            0,
            vec![2, 3]
        )
    ); // 4
    println!(
        "{}",
        minimum_distance(
            4,
            vec![vec![0, 1, 1], vec![1, 2, 3], vec![2, 3, 2], vec![3, 0, 4]],
            0,
            vec![2, 3]
        )
    ); // 4
    println!(
        "{}",
        minimum_distance(
            5,
            vec![
                vec![0, 1, 2],
                vec![0, 2, 4],
                vec![1, 3, 1],
                vec![2, 3, 3],
                vec![3, 4, 2]
            ],
            1,
            vec![0, 4]
        )
    ); // 3
    println!(
        "{}",
        minimum_distance(
            4,
            vec![vec![0, 1, 1], vec![1, 2, 3], vec![2, 3, 2]],
            3,
            vec![0, 1]
        )
    ); // -1
    println!(
        "{}",
        minimum_distance(
            4,
            vec![vec![1, 0, 1], vec![2, 1, 3], vec![3, 2, 2]],
            3,
            vec![0, 1]
        )
    ); // 5
}
