use std::collections::HashMap;

// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
pub fn count_pairs(n: i32, edges: Vec<Vec<i32>>) -> i64 {
    fn dfs(map: &HashMap<i32, Vec<i32>>, visited: &mut Vec<bool>, node: i32) -> i32 {
        let mut count = 1;
        visited[node as usize] = true;
        for neighbor in map.get(&node).unwrap_or(&vec![]).iter() {
            if visited[*neighbor as usize] {
                continue;
            }
            count += dfs(map, visited, *neighbor);
        }
        count
    }

    let mut map: HashMap<i32, Vec<i32>> = HashMap::new();
    for edge in edges.into_iter() {
        let from = edge[0];
        let to = edge[1];
        map.entry(from).or_insert(vec![]).push(to);
        map.entry(to).or_insert(vec![]).push(from);
    }

    let mut visited = vec![false; n as usize];
    let mut counts = vec![];
    for i in 0..n {
        if visited[i as usize] {
            continue;
        }
        counts.push(dfs(&map, &mut visited, i));
    }
    let mut answer = 0;
    for i in 0..counts.len() {
        for j in i + 1..counts.len() {
            answer += counts[i] as i64 * counts[j] as i64;
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        count_pairs(3, vec![vec![0, 1], vec![0, 2], vec![1, 2]])
    ); // 0
    println!(
        "{}",
        count_pairs(
            7,
            vec![vec![0, 2], vec![0, 5], vec![2, 4], vec![1, 6], vec![5, 4]]
        )
    ); // 14
}
