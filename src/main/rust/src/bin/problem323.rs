// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
pub fn count_components(n: i32, edges: Vec<Vec<i32>>) -> i32 {
    fn dfs(adj_list: &Vec<Vec<i32>>, node: i32, visited: &mut Vec<bool>) {
        if visited[node as usize] {
            return;
        }
        visited[node as usize] = true;
        for adj in adj_list[node as usize].iter() {
            dfs(adj_list, *adj, visited);
        }
    }

    let mut adj_list: Vec<Vec<i32>> = vec![vec![]; n as usize];
    for edge in edges {
        adj_list[edge[0] as usize].push(edge[1]);
        adj_list[edge[1] as usize].push(edge[0]);
    }
    let mut answer = 0;
    let mut visited: Vec<bool> = vec![false; n as usize];
    for i in 0..n {
        if visited[i as usize] {
            continue;
        }
        dfs(&adj_list, i, &mut visited);
        answer += 1;
    }
    answer
}

fn main() {
    println!(
        "{}",
        count_components(5, vec![vec![0, 1], vec![1, 2], vec![3, 4]])
    ); // 2
    println!(
        "{}",
        count_components(5, vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![3, 4]])
    ); // 1
}
