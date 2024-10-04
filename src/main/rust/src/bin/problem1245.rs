use std::collections::HashMap;

// https://leetcode.com/problems/tree-diameter/description/
pub fn tree_diameter(edges: Vec<Vec<i32>>) -> i32 {
    fn longest_path(
        graph: &HashMap<i32, Vec<i32>>,
        source: i32,
        accu: i32,
        visited: &mut Vec<bool>,
        target: &mut i32,
        length: &mut i32,
    ) {
        if visited[source as usize] {
            return;
        }
        visited[source as usize] = true;
        if let Some(children) = graph.get(&source) {
            for child in children.iter() {
                longest_path(graph, *child, accu + 1, visited, target, length);
            }
        }
        if *length < accu {
            *target = source;
            *length = accu;
        }
    }

    let n = edges.len();
    let mut graph: HashMap<i32, Vec<i32>> = HashMap::new();
    for edge in edges {
        graph.entry(edge[0]).or_insert(Vec::new()).push(edge[1]);
        graph.entry(edge[1]).or_insert(Vec::new()).push(edge[0]);
    }

    let mut visited = vec![false; n + 1];
    let mut target = 0;
    let mut length = 0;
    longest_path(&graph, 0, 0, &mut visited, &mut target, &mut length);

    let mut visited = vec![false; n + 1];
    let mut answer = 0;
    longest_path(&graph, target, 0, &mut visited, &mut target, &mut answer);

    answer
}

fn main() {
    println!("{}", tree_diameter(vec![vec![0, 1], vec![0, 2]])); // 2
    println!(
        "{}",
        tree_diameter(vec![
            vec![0, 1],
            vec![1, 2],
            vec![2, 3],
            vec![1, 4],
            vec![4, 5]
        ])
    ); // 4
    println!(
        "{}",
        tree_diameter(vec![
            vec![0, 1],
            vec![0, 2],
            vec![2, 3],
            vec![0, 4],
            vec![4, 5]
        ])
    ); // 4
    println!("{}", tree_diameter(vec![vec![1, 0], vec![0, 2]])); // 2
}
