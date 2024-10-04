use std::collections::HashMap;

// https://leetcode.com/problems/tree-diameter/description/
pub fn tree_diameter(edges: Vec<Vec<i32>>) -> i32 {
    let mut graph: HashMap<i32, Vec<i32>> = HashMap::new();
    for edge in edges {
        graph.entry(edge[0]).or_insert(Vec::new()).push(edge[1]);
        graph.entry(edge[1]).or_insert(Vec::new()).push(edge[0]);
    }
    0
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
    println!("{}", tree_diameter(vec![vec![1, 0], vec![0, 2]])); // 2
}
