use std::cmp::Reverse;
use std::collections::{BinaryHeap, HashMap, HashSet};

// https://leetcode.com/problems/connecting-cities-with-minimum-cost/description/
pub fn minimum_cost(n: i32, connections: Vec<Vec<i32>>) -> i32 {
    fn build_graph(connections: &Vec<Vec<i32>>) -> HashMap<i32, Vec<(i32, i32)>> {
        let mut graph: HashMap<i32, Vec<(i32, i32)>> = HashMap::new();
        for connection in connections.iter() {
            let from = connection[0];
            let to = connection[1];
            let cost = connection[2];
            graph.entry(from).or_insert(Vec::new()).push((to, cost));
            graph.entry(to).or_insert(Vec::new()).push((from, cost));
        }
        graph
    }

    fn visit(
        graph: &HashMap<i32, Vec<(i32, i32)>>,
        visited: &mut HashSet<i32>,
        binary_heap: &mut BinaryHeap<Reverse<(i32, i32, i32)>>,
        from: i32,
    ) {
        visited.insert(from);
        for (to, cost) in graph.get(&from).unwrap_or(&Vec::new()).iter() {
            if !visited.contains(to) {
                binary_heap.push(Reverse((*cost, from, *to)));
            }
        }
    }

    let mut answer = 0;
    let graph = build_graph(&connections);
    let mut binary_heap: BinaryHeap<Reverse<(i32, i32, i32)>> = BinaryHeap::new();
    let mut visited: HashSet<i32> = HashSet::new();
    visit(&graph, &mut visited, &mut binary_heap, 1);
    while let Some(Reverse((cost, from, to))) = binary_heap.pop() {
        if visited.contains(&from) && visited.contains(&to) {
            continue;
        }
        answer += cost;
        if !visited.contains(&from) {
            visit(&graph, &mut visited, &mut binary_heap, from);
        }
        if !visited.contains(&to) {
            visit(&graph, &mut visited, &mut binary_heap, to);
        }
    }
    if visited.len() != n as usize {
        -1
    } else {
        answer
    }
}

fn main() {
    println!(
        "{}",
        minimum_cost(3, vec![vec![1, 2, 5], vec![1, 3, 6], vec![2, 3, 1]])
    ); // 6
    println!("{}", minimum_cost(4, vec![vec![1, 2, 3], vec![3, 4, 4]])); // -1
}
