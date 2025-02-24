use std::collections::VecDeque;

// https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/
pub fn shortest_distance_after_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
    fn shortest_path(graph: &Vec<Vec<usize>>, start: usize) -> i32 {
        let mut shortest_distance = i32::MAX;
        let mut deque: VecDeque<(usize, i32)> = VecDeque::new();
        deque.push_back((start, 0));
        while !deque.is_empty() {
            if let Some((node, distance)) = deque.pop_front() {
                if node == graph.len() - 1 {
                    shortest_distance = shortest_distance.min(distance);
                }
                for adj in graph[node].iter() {
                    deque.push_back((*adj, distance + 1));
                }
            }
        }
        shortest_distance
    }

    let mut graph: Vec<Vec<usize>> = vec![vec![]; n as usize];
    for i in 0..n - 1 {
        graph[i as usize].push(i as usize + 1);
    }
    let mut answer = vec![];
    for query in queries {
        let from = query[0];
        let to = query[1];
        graph[from as usize].push(to as usize);
        answer.push(shortest_path(&graph, 0));
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
