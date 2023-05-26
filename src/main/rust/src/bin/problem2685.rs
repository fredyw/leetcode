use std::collections::HashMap;

// https://leetcode.com/problems/count-the-number-of-complete-components/
pub fn count_complete_components(n: i32, edges: Vec<Vec<i32>>) -> i32 {
    fn extract_subgraph(
        graph: &HashMap<i32, Vec<i32>>,
        parent: i32,
        visited: &mut Vec<bool>,
        subgraph: &mut HashMap<i32, i32>,
    ) {
        if visited[parent as usize] {
            return;
        }
        visited[parent as usize] = true;
        for child in graph.get(&parent).unwrap_or(&vec![]) {
            *subgraph.entry(parent).or_insert(0) += 1;
            extract_subgraph(graph, *child, visited, subgraph);
        }
    }

    fn is_complete(graph: &HashMap<i32, i32>) -> bool {
        for count in graph.values() {
            if *count != graph.keys().len() as i32 - 1 {
                return false;
            }
        }
        true
    }

    let mut graph: HashMap<i32, Vec<i32>> = HashMap::new();
    for edge in edges {
        graph.entry(edge[0]).or_insert(vec![]).push(edge[1]);
        graph.entry(edge[1]).or_insert(vec![]).push(edge[0]);
    }
    let mut visited: Vec<bool> = vec![false; n as usize];
    let mut answer = 0;
    for i in 0..n {
        if visited[i as usize] {
            continue;
        }
        let mut subgraph: HashMap<i32, i32> = HashMap::new();
        extract_subgraph(&graph, i, &mut visited, &mut subgraph);
        if is_complete(&subgraph) {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        count_complete_components(6, vec![vec![0, 1], vec![0, 2], vec![1, 2], vec![3, 4]])
    ); // 3
    println!(
        "{}",
        count_complete_components(
            6,
            vec![vec![0, 1], vec![0, 2], vec![1, 2], vec![3, 4], vec![3, 5]]
        )
    ); // 1
    println!(
        "{}",
        count_complete_components(4, vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![3, 0]])
    ); // 0
    println!(
        "{}",
        count_complete_components(4, vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![3, 0]])
    ); // 1
}
