use std::collections::{HashMap, HashSet};

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

    fn visit(graph: &HashMap<i32, Vec<i32>>, visited: &mut HashSet<i32>, node: i32) {
        visited.insert(node);
        for adjacent in graph.get(&node).unwrap_or(&Vec::new()).iter() {
            if !visited.contains(adjacent) {
                visit(&graph, visited, *adjacent);
            }
        }
    }

    let graph = build_graph(&connections);

    todo!()
}

fn main() {
    println!(
        "{}",
        minimum_cost(3, vec![vec![1, 2, 5], vec![1, 3, 6], vec![2, 3, 1]])
    ); // 6
    println!("{}", minimum_cost(4, vec![vec![1, 2, 3], vec![3, 4, 4]])); // -1
}
