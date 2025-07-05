use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/description/
pub fn max_target_nodes(edges1: Vec<Vec<i32>>, edges2: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
    #[derive(Eq, PartialEq, Hash, Debug)]
    struct Node {
        tree: i32,
        value: i32,
    }

    impl Node {
        fn one(value: i32) -> Node {
            Node { tree: 1, value }
        }

        fn two(value: i32) -> Node {
            Node { tree: 2, value }
        }
    }

    fn count<'a>(
        graph: &'a HashMap<Node, Vec<Node>>,
        node: &'a Node,
        k: i32,
        visited: &mut HashSet<&'a Node>,
    ) -> i32 {
        if k == 0 {
            return 0;
        }
        let mut c = 0;
        visited.insert(node);
        if let Some(v) = graph.get(&node) {
            for adj in v.iter() {
                if !visited.contains(adj) {
                    c += count(graph, adj, k - 1, visited) + 1;
                }
            }
        }
        c
    }

    let mut graph1: HashMap<Node, Vec<Node>> = HashMap::new();
    for edge in edges1 {
        graph1
            .entry(Node::one(edge[0]))
            .or_insert(vec![])
            .push(Node::one(edge[1]));
        graph1
            .entry(Node::one(edge[1]))
            .or_insert(vec![])
            .push(Node::one(edge[0]));
    }
    let mut graph2: HashMap<Node, Vec<Node>> = HashMap::new();
    for edge in edges2 {
        graph2
            .entry(Node::two(edge[0]))
            .or_insert(vec![])
            .push(Node::two(edge[1]));
        graph2
            .entry(Node::two(edge[1]))
            .or_insert(vec![])
            .push(Node::two(edge[0]));
    }
    vec![]
}

fn main() {
    println!(
        "{:?}",
        max_target_nodes(
            vec![vec![0, 1], vec![0, 2], vec![2, 3], vec![2, 4]],
            vec![
                vec![0, 1],
                vec![0, 2],
                vec![0, 3],
                vec![2, 7],
                vec![1, 4],
                vec![4, 5],
                vec![4, 6]
            ],
            2
        )
    ); // [9,7,9,8,8]
       // println!(
       //     "{:?}",
       //     max_target_nodes(
       //         vec![vec![0, 1], vec![0, 2], vec![0, 3], vec![0, 4]],
       //         vec![vec![0, 1], vec![1, 2], vec![2, 3]],
       //         1
       //     )
       // ); // [9,7,9,8,8]
}
