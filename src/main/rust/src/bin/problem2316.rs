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
    let mut answer = 0;
    let mut sum = n as i64;
    for i in 0..n {
        if visited[i as usize] {
            continue;
        }
        let count = dfs(&map, &mut visited, i) as i64;
        sum -= count;
        answer += sum * count;
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
    println!("{}", count_pairs(100, vec![])); // 4950
    println!("{}", count_pairs(10, vec![])); // 45
    println!("{}", count_pairs(10000, vec![])); // 49995000
    println!("{}", count_pairs(10000, vec![vec![4, 5], vec![7, 8]])); // 49994998
}
