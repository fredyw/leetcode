// https://leetcode.com/problems/delete-tree-nodes/description/
pub fn delete_tree_nodes(nodes: i32, parent: Vec<i32>, value: Vec<i32>) -> i32 {
    fn delete_tree_node(
        graph: &Vec<Vec<usize>>,
        values: &Vec<i32>,
        node: usize,
        num_deleted_nodes: &mut i32,
    ) -> (i32, i32) {
        let mut num_nodes = 1;
        let mut sum = values[node];
        let mut child_sum = 0;
        for child in graph[node].iter() {
            let (n, s) = delete_tree_node(graph, values, *child, num_deleted_nodes);
            num_nodes += n;
            sum += s;
            if s == 0 {
                child_sum += s;
            }
        }
        if sum == 0 {
            *num_deleted_nodes += num_nodes;
        } else {
            *num_deleted_nodes += child_sum;
        }
        (num_nodes, sum)
    }

    let mut graph: Vec<Vec<usize>> = vec![vec![]; nodes as usize];
    let mut root = 0;
    for (i, n) in parent.iter().enumerate() {
        if *n == -1 {
            root = i;
        } else {
            graph[*n as usize].push(i);
        }
    }

    let mut num_deleted_nodes = 0;
    let (total_num_nodes, sum) = delete_tree_node(&graph, &value, root, &mut num_deleted_nodes);
    total_num_nodes - num_deleted_nodes
}

fn main() {
    println!(
        "{}",
        delete_tree_nodes(7, vec![-1, 0, 0, 1, 2, 2, 2], vec![1, -2, 4, 0, -2, -1, -1])
    ); // 2
    println!(
        "{}",
        delete_tree_nodes(7, vec![-1, 0, 0, 1, 2, 2, 2], vec![1, -2, 4, 0, -2, -1, -2])
    ); // 6
    println!(
        "{}",
        delete_tree_nodes(7, vec![-1, 0, 0, 1, 2, 2, 2], vec![1, -2, -2, 0, -2, 0, 0])
    ); // 4
    println!(
        "{}",
        delete_tree_nodes(7, vec![-1, 0, 0, 1, 2, 2, 2], vec![1, -2, 4, 0, -2, 0, 0])
    ); // 2
    println!(
        "{}",
        delete_tree_nodes(7, vec![-1, 0, 0, 1, 2, 2, 2], vec![1, -2, 4, 0, 0, 0, 0])
    ); // 3
    println!(
        "{}",
        delete_tree_nodes(7, vec![-1, 0, 0, 1, 2, 2, 2], vec![1, -2, 0, 0, 0, 0, 0])
    ); // 2
}
