use std::cmp::Reverse;
use std::collections::{BinaryHeap, HashMap};

// https://leetcode.com/problems/minimum-cost-to-convert-string-i/
pub fn minimum_cost(
    source: String,
    target: String,
    original: Vec<char>,
    changed: Vec<char>,
    cost: Vec<i32>,
) -> i64 {
    fn build_graph(
        original: &Vec<char>,
        changed: &Vec<char>,
        cost: &Vec<i32>,
    ) -> HashMap<char, Vec<(char, i32)>> {
        let mut graph = HashMap::new();
        for i in 0..original.len() {
            graph
                .entry(original[i])
                .or_insert(Vec::new())
                .push((changed[i], cost[i]));
        }
        graph
    }

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

    let mut answer = 0;
    let source: Vec<char> = source.chars().collect();
    let target: Vec<char> = target.chars().collect();
    let graph = build_graph(&original, &changed, &cost);
    let mut shortest_path_map: HashMap<char, HashMap<char, Option<i32>>> = HashMap::new();
    for i in 0..source.len() {
        if let Some(map) = shortest_path_map.get(&source[i]) {
            if let Some(cost) = map.get(&target[i]) {
                if let Some(cost) = *cost {
                    answer += cost as i64;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            let map = shortest_path(&graph, source[i]);
            if let Some(cost) = map.get(&target[i]) {
                if let Some(cost) = *cost {
                    answer += cost as i64;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
            shortest_path_map.insert(source[i], map);
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        minimum_cost(
            "abcd".to_string(),
            "acbe".to_string(),
            vec!['a', 'b', 'c', 'c', 'e', 'd'],
            vec!['b', 'c', 'b', 'e', 'b', 'e'],
            vec![2, 5, 5, 1, 2, 20],
        )
    ); // 28
    println!(
        "{}",
        minimum_cost(
            "aaaa".to_string(),
            "bbbb".to_string(),
            vec!['a', 'c'],
            vec!['c', 'b'],
            vec![1, 2],
        )
    ); // 12
    println!(
        "{}",
        minimum_cost(
            "abcd".to_string(),
            "abce".to_string(),
            vec!['a'],
            vec!['e'],
            vec![10000],
        )
    ); // -1
}
