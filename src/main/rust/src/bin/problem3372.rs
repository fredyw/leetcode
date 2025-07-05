use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/description/
pub fn max_target_nodes(edges1: Vec<Vec<i32>>, edges2: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
    fn count(graph: &HashMap<i32, Vec<i32>>, node: i32, k: i32, visited: &mut HashSet<i32>) -> i32 {
        if k == 0 {
            return 0;
        }
        let mut c = 0;
        visited.insert(node);
        if let Some(v) = graph.get(&node) {
            for adj in v.iter() {
                if !visited.contains(adj) {
                    c += count(graph, *adj, k - 1, visited) + 1;
                }
            }
        }
        c
    }

    let mut graph1: HashMap<i32, Vec<i32>> = HashMap::new();
    for edge in edges1 {
        graph1.entry(edge[0]).or_insert(vec![]).push(edge[1]);
        graph1.entry(edge[1]).or_insert(vec![]).push(edge[0]);
    }
    let mut counts1: Vec<i32> = vec![0; graph1.len()];
    for node in graph1.keys() {
        counts1[*node as usize] = count(&graph1, *node, k, &mut HashSet::new()) + 1;
    }
    let mut graph2: HashMap<i32, Vec<i32>> = HashMap::new();
    for edge in edges2 {
        graph2.entry(edge[0]).or_insert(vec![]).push(edge[1]);
        graph2.entry(edge[1]).or_insert(vec![]).push(edge[0]);
    }
    let mut counts2: Vec<i32> = vec![0; graph2.len()];
    for node in graph2.keys() {
        counts2[*node as usize] = count(&graph2, *node, k - 1, &mut HashSet::new()) + 1;
    }
    let mut answer: Vec<i32> = vec![0; counts1.len()];
    for (i, c1) in counts1.iter().enumerate() {
        let mut max = 0;
        for (_, c2) in counts2.iter().enumerate() {
            max = max.max(*c1 + *c2);
        }
        answer[i] = max;
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        max_target_nodes(
            vec![vec![0, 1], vec![0, 2], vec![2, 3], vec![2, 4]],
            vec![
                vec![0, 1],
                vec![0, 2],
                vec![0, 3],
                vec![2, 7],
                vec![1, 4],
                vec![4, 5],
                vec![4, 6]
            ],
            2
        )
    ); // [9,7,9,8,8]
    println!(
        "{:?}",
        max_target_nodes(
            vec![vec![0, 1], vec![0, 2], vec![0, 3], vec![0, 4]],
            vec![vec![0, 1], vec![1, 2], vec![2, 3]],
            1
        )
    ); // [6,3,3,3,3]
    println!(
        "{:?}",
        max_target_nodes(vec![vec![0, 1]], vec![vec![0, 1]], 1)
    ); // [1,1]
}
