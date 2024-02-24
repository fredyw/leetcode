use std::collections::{HashMap, VecDeque};

// https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i/description/
pub fn count_of_pairs(n: i32, x: i32, y: i32) -> Vec<i32> {
    fn bfs(graph: &HashMap<i32, Vec<i32>>, start: i32, answer: &mut Vec<i32>) {
        let mut deque: VecDeque<i32> = VecDeque::new();
        let mut visited: Vec<bool> = vec![false; graph.len()];
        let mut i: i32 = -1;
        deque.push_back(start);
        while !deque.is_empty() {
            let size = deque.len();
            for _ in 0..size {
                let house = deque.pop_front().unwrap();
                if visited[house as usize - 1] {
                    continue;
                }
                if i >= 0 {
                    answer[i as usize] += 1;
                }
                visited[house as usize - 1] = true;
                if let Some(neighbors) = graph.get(&house) {
                    for neighbor in neighbors.iter() {
                        deque.push_back(*neighbor);
                    }
                }
            }
            i += 1;
        }
    }

    let mut graph: HashMap<i32, Vec<i32>> = HashMap::new();
    graph.entry(x).or_insert(vec![]).push(y);
    graph.entry(y).or_insert(vec![]).push(x);
    for i in 1..n {
        graph.entry(i).or_insert(vec![]).push(i + 1);
        graph.entry(i + 1).or_insert(vec![]).push(i);
    }
    let mut answer = vec![0; n as usize];
    for i in 1..=n {
        bfs(&graph, i, &mut answer);
    }
    answer
}

fn main() {
    println!("{:?}", count_of_pairs(3, 1, 3)); // [6,0,0]
    println!("{:?}", count_of_pairs(5, 2, 4)); // [10,8,2,0,0]
    println!("{:?}", count_of_pairs(4, 1, 1)); // [6,4,2,0]
    println!("{:?}", count_of_pairs(5, 1, 5)); // [10,10,0,0,0]
    println!("{:?}", count_of_pairs(5, 1, 1)); // [8,6,4,2,0]
}
