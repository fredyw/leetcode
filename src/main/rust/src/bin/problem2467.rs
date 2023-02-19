use std::collections::{HashMap, HashSet, VecDeque};

// https://leetcode.com/problems/most-profitable-path-in-a-tree/
pub fn most_profitable_path(edges: Vec<Vec<i32>>, bob: i32, amount: Vec<i32>) -> i32 {
    fn build_graph(edges: &Vec<Vec<i32>>) -> HashMap<i32, Vec<i32>> {
        let mut map: HashMap<i32, Vec<i32>> = HashMap::new();
        for edge in edges.into_iter() {
            let from = edge[0];
            let to = edge[1];
            map.entry(from).or_insert(vec![]).push(to);
            map.entry(to).or_insert(vec![]).push(from);
        }
        map
    }

    fn get_bob_path(graph: &HashMap<i32, Vec<i32>>, bob: i32) -> HashMap<i32, i32> {
        #[derive(Debug, Eq, PartialEq)]
        struct EdgeTo {
            parent: i32,
            second: i32,
        }

        impl EdgeTo {
            fn new(parent: i32, second: i32) -> EdgeTo {
                EdgeTo { parent, second }
            }
        }

        let mut edge_to_map: HashMap<i32, EdgeTo> = HashMap::new();
        let mut deque: VecDeque<(i32, i32)> = VecDeque::new();
        let mut visited: HashSet<i32> = HashSet::new();
        deque.push_back((bob, 0));
        while !deque.is_empty() {
            let (node, second) = deque.pop_front().unwrap();
            if node == 0 {
                break;
            }
            visited.insert(node);
            for neighbor in graph.get(&node).unwrap_or(&vec![]) {
                if visited.contains(neighbor) {
                    continue;
                }
                deque.push_back((*neighbor, second + 1));
                edge_to_map.insert(*neighbor, EdgeTo::new(node, second + 1));
            }
        }

        let mut bob_path: HashMap<i32, i32> = HashMap::new();
        let mut node: i32 = 0;
        while let Some(edge_to) = edge_to_map.get(&node) {
            bob_path.insert(node, edge_to.second);
            node = edge_to.parent;
        }
        bob_path.insert(bob, 0);
        bob_path
    }

    fn max_profitable_path(
        graph: &HashMap<i32, Vec<i32>>,
        bob_path: &HashMap<i32, i32>,
        amounts: &Vec<i32>,
        visited: &mut HashSet<i32>,
        node: i32,
        second: i32,
        amount: i32,
        answer: &mut i32,
    ) {
        visited.insert(node);
        let mut is_leaf = true;
        for neighbor in graph.get(&node).unwrap_or(&vec![]) {
            if visited.contains(&neighbor) {
                continue;
            }
            is_leaf = false;
            let neighbor_amount = match bob_path.get(&neighbor) {
                None => amounts[*neighbor as usize],
                Some(s) => {
                    if second + 1 == *s {
                        amounts[*neighbor as usize] / 2
                    } else if second + 1 < *s {
                        amounts[*neighbor as usize]
                    } else {
                        0
                    }
                }
            };
            max_profitable_path(
                graph,
                bob_path,
                amounts,
                visited,
                *neighbor,
                second + 1,
                amount + neighbor_amount,
                answer,
            );
        }
        if is_leaf {
            *answer = (*answer).max(amount);
        }
    }

    let graph = build_graph(&edges);
    let bob_path = get_bob_path(&graph, bob);
    let mut visited: HashSet<i32> = HashSet::new();
    let mut answer = i32::MIN;
    max_profitable_path(
        &graph,
        &bob_path,
        &amount,
        &mut visited,
        0,
        0,
        amount[0],
        &mut answer,
    );
    answer
}

fn main() {
    println!(
        "{}",
        most_profitable_path(
            vec![vec![0, 1], vec![1, 2], vec![1, 3], vec![3, 4]],
            3,
            vec![-2, 4, 2, -4, 6]
        )
    ); // 6
    println!(
        "{}",
        most_profitable_path(
            vec![vec![0, 1], vec![1, 2], vec![1, 3], vec![3, 4], vec![4, 5]],
            4,
            vec![-2, 4, 2, -4, 6, -8]
        )
    ); // 4
    println!(
        "{}",
        most_profitable_path(
            vec![vec![0, 1], vec![1, 2], vec![1, 3], vec![3, 4], vec![4, 5]],
            3,
            vec![-2, 4, 2, -4, 6, -8]
        )
    ); // 2
    println!(
        "{}",
        most_profitable_path(vec![vec![0, 1]], 1, vec![-7280, 2350])
    ); // -7280
}
