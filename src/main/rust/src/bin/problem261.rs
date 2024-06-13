// https://leetcode.com/problems/graph-valid-tree/description/
pub fn valid_tree(n: i32, edges: Vec<Vec<i32>>) -> bool {
    fn build_graph(edges: &Vec<Vec<i32>>, n: i32) -> Vec<Vec<i32>> {
        let mut adj_list = vec![vec![]; n as usize];
        for edge in edges.iter() {
            adj_list[edge[0] as usize].push(edge[1]);
            adj_list[edge[1] as usize].push(edge[0]);
        }
        adj_list
    }

    fn has_cycle(graph: &Vec<Vec<i32>>, node: i32, parent: i32, visited: &mut Vec<bool>) -> bool {
        visited[node as usize] = true;
        for adjacent in graph[node as usize].iter() {
            if !visited[*adjacent as usize] {
                if has_cycle(graph, *adjacent, node, visited) {
                    return true;
                }
            } else {
                // Has cycle.
                if *adjacent != parent {
                    return true;
                }
            }
        }
        false
    }

    let graph = build_graph(&edges, n);
    let mut visited = vec![false; n as usize];
    if has_cycle(&graph, 0, 0, &mut visited) {
        return false;
    }
    // Check if all the nodes are connected.
    visited.iter().all(|b| *b)
}

fn main() {
    println!(
        "{}",
        valid_tree(5, vec![vec![0, 1], vec![0, 2], vec![0, 3], vec![1, 4]])
    ); // true
    println!(
        "{}",
        valid_tree(
            5,
            vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![1, 3], vec![1, 4]]
        )
    ); // false
    println!("{}", valid_tree(4, vec![vec![0, 1], vec![2, 3]])); // false
}
