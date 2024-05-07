use std::collections::HashMap;

// https://leetcode.com/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network/description/
pub fn count_pairs_of_connectable_servers(edges: Vec<Vec<i32>>, signal_speed: i32) -> Vec<i32> {
    #[derive(Debug)]
    struct Edge {
        to: usize,
        weight: i32,
    }

    fn dfs(
        graph: &HashMap<usize, Vec<Edge>>,
        signal_speed: i32,
        root: usize,
        from: usize,
        sum: i32,
        visited: &mut Vec<bool>,
        answer: &mut Vec<i32>,
    ) {
        if sum > 0 && sum % signal_speed == 0 {
            answer[root] += 1;
        }
        visited[from] = true;
        for edge in graph.get(&from).unwrap_or(&vec![]) {
            if visited[edge.to] {
                continue;
            }
            dfs(
                graph,
                signal_speed,
                root,
                edge.to,
                sum + edge.weight,
                visited,
                answer,
            );
        }
    }

    let mut graph: HashMap<usize, Vec<Edge>> = HashMap::new();
    for edge in edges.iter() {
        let from = edge[0] as usize;
        let to = edge[1] as usize;
        let weight = edge[2];
        graph
            .entry(from)
            .or_insert(vec![])
            .push(Edge { to, weight });
        graph
            .entry(to)
            .or_insert(vec![])
            .push(Edge { to: from, weight });
    }

    let mut answer = vec![0; graph.len()];
    for (from, edges) in graph.iter() {
        if edges.len() == 1 {
            continue;
        }
        dfs(
            &graph,
            signal_speed,
            *from,
            *from,
            0,
            &mut vec![false; graph.len()],
            &mut answer,
        );
    }
    answer
}

fn main() {
    // println!(
    //     "{:?}",
    //     count_pairs_of_connectable_servers(
    //         vec![
    //             vec![0, 1, 1],
    //             vec![1, 2, 5],
    //             vec![2, 3, 13],
    //             vec![3, 4, 9],
    //             vec![4, 5, 2]
    //         ],
    //         1
    //     )
    // ); // [0,4,6,6,4,0]
    println!(
        "{:?}",
        count_pairs_of_connectable_servers(
            vec![
                vec![0, 1, 6],
                vec![1, 2, 2],
                vec![2, 3, 4],
                vec![3, 4, 1],
                vec![4, 5, 1]
            ],
            2
        )
    ); // [0,3,4,3,0,0]
       // println!(
       //     "{:?}",
       //     count_pairs_of_connectable_servers(vec![vec![0, 1, 1], vec![1, 2, 1]], 2)
       // ); // [0,0,0]
       // println!(
       //     "{:?}",
       //     count_pairs_of_connectable_servers(
       //         vec![
       //             vec![0, 6, 3],
       //             vec![6, 5, 3],
       //             vec![0, 3, 1],
       //             vec![3, 2, 7],
       //             vec![3, 1, 6],
       //             vec![3, 4, 2]
       //         ],
       //         3
       //     )
       // ); // [2,0,0,0,0,0,2]
       // println!(
       //     "{:?}",
       //     count_pairs_of_connectable_servers(
       //         vec![
       //             vec![0, 1, 1],
       //             vec![1, 2, 5],
       //             vec![2, 3, 13],
       //             vec![3, 4, 9],
       //             vec![4, 5, 2]
       //         ],
       //         2
       //     )
       // ); // [0,0,2,0,2,0]
}
