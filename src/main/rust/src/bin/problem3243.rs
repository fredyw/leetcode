use std::collections::VecDeque;

// https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/
pub fn shortest_distance_after_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
    fn shortest_path(graph: &Vec<Vec<usize>>, start: usize, shortest_paths: &mut Vec<i32>) {
        let mut deque: VecDeque<(usize, i32)> = VecDeque::new();
        deque.push_back((
            start,
            if shortest_paths[start] == i32::MAX {
                0
            } else {
                shortest_paths[start]
            },
        ));
        while !deque.is_empty() {
            if let Some((node, distance)) = deque.pop_front() {
                shortest_paths[node] = shortest_paths[node].min(distance);
                for adj in graph[node].iter() {
                    deque.push_back((*adj, distance + 1));
                }
            }
        }
    }

    let mut graph: Vec<Vec<usize>> = vec![vec![]; n as usize];
    for i in 0..n - 1 {
        graph[i as usize].push(i as usize + 1);
    }
    let mut answer = vec![];
    let mut shortest_paths: Vec<i32> = vec![i32::MAX; graph.len()];
    for (i, query) in queries.into_iter().enumerate() {
        let from = query[0];
        let to = query[1];
        graph[from as usize].push(to as usize);
        if i == 0 {
            shortest_path(&graph, 0, &mut shortest_paths);
        } else {
            shortest_path(&graph, from as usize, &mut shortest_paths);
        }
        answer.push(shortest_paths[n as usize - 1]);
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        shortest_distance_after_queries(5, vec![vec![2, 4], vec![0, 2], vec![0, 4]])
    ); // [3,2,1]
    println!(
        "{:?}",
        shortest_distance_after_queries(4, vec![vec![0, 3], vec![0, 2]])
    ); // [1,1]
}
