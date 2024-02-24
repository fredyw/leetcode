use std::collections::VecDeque;

// https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i/description/
pub fn count_of_pairs(n: i32, x: i32, y: i32) -> Vec<i32> {
    fn bfs(graph: &Vec<Vec<usize>>, start: usize, answer: &mut Vec<i32>) {
        let mut deque: VecDeque<usize> = VecDeque::new();
        let mut visited: Vec<bool> = vec![false; graph.len()];
        let mut i: i32 = -1;
        deque.push_back(start);
        while !deque.is_empty() {
            let size = deque.len();
            for _ in 0..size {
                let house = deque.pop_front().unwrap();
                if visited[house] {
                    continue;
                }
                if i >= 0 {
                    answer[i as usize] += 1;
                }
                visited[house] = true;
                for neighbor in graph[house].iter() {
                    deque.push_back(*neighbor);
                }
            }
            i += 1;
        }
    }

    let mut graph: Vec<Vec<usize>> = vec![vec![]; n as usize];
    graph[x as usize - 1].push(y as usize - 1);
    graph[y as usize - 1].push(x as usize - 1);
    for i in 0..n as usize - 1 {
        graph[i].push(i + 1);
        graph[i + 1].push(i);
    }
    let mut answer = vec![0; n as usize];
    for i in 0..n as usize {
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
