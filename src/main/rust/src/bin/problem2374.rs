use std::collections::HashMap;

// https://leetcode.com/problems/node-with-highest-edge-score/
pub fn edge_score(edges: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, i64> = HashMap::new();
    for (i, edge) in edges.into_iter().enumerate() {
        *map.entry(edge).or_insert(0) += i as i64;
    }
    *map.iter()
        .max_by(|a, b| {
            if a.1 == b.1 {
                return b.0.cmp(a.0);
            }
            a.1.cmp(b.1)
        })
        .unwrap()
        .0
}

fn main() {
    println!("{}", edge_score(vec![1, 0, 0, 0, 0, 7, 7, 5])); // 7
    println!("{}", edge_score(vec![2, 0, 0, 2])); // 0
}
