use std::collections::HashSet;

// https://leetcode.com/problems/remove-methods-from-project/description/
pub fn remaining_methods(n: i32, k: i32, invocations: Vec<Vec<i32>>) -> Vec<i32> {
    fn dfs(adj_list: &Vec<Vec<usize>>, visited: &mut Vec<bool>, node: usize) {
        visited[node] = true;
        for &neighbor in &adj_list[node] {
            if !visited[neighbor as usize] {
                dfs(adj_list, visited, neighbor as usize);
            }
        }
    }

    let mut adj_list: Vec<Vec<usize>> = vec![vec![]; n as usize];
    for v in invocations {
        adj_list[v[0] as usize].push(v[1] as usize);
    }
    let mut suspicious = vec![false; n as usize];
    dfs(&adj_list, &mut suspicious, k as usize);
    println!("{:?}", suspicious);
    vec![]
}

fn main() {
    println!(
        "{:?}",
        remaining_methods(4, 1, vec![vec![1, 2], vec![0, 1], vec![3, 2]])
    ); // [0,1,2,3]
    println!(
        "{:?}",
        remaining_methods(5, 0, vec![vec![1, 2], vec![0, 2], vec![0, 1], vec![3, 4]])
    ); // [3,4]
    println!(
        "{:?}",
        remaining_methods(3, 2, vec![vec![1, 2], vec![0, 1], vec![2, 0]])
    ); // []
    println!(
        "{:?}",
        remaining_methods(4, 0, vec![vec![1, 2], vec![0, 1], vec![3, 2]])
    ); // [0,1,2,3]
}
