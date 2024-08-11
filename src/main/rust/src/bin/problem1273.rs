// https://leetcode.com/problems/delete-tree-nodes/description/
pub fn delete_tree_nodes(nodes: i32, parent: Vec<i32>, value: Vec<i32>) -> i32 {
    struct Result {
        total_num_nodes: i32,
        sum: i32,
        num_deleted_nodes: i32,
    }

    fn delete_tree_node(graph: &Vec<Vec<usize>>, values: &Vec<i32>, node: usize) -> Result {
        let mut total_num_nodes = 1;
        let mut sum = values[node];
        let mut num_deleted_nodes = 0;
        for child in graph[node].iter() {
            let r = delete_tree_node(graph, values, *child);
            total_num_nodes += r.total_num_nodes;
            num_deleted_nodes += r.num_deleted_nodes;
            sum += r.sum;
        }
        Result {
            total_num_nodes,
            sum,
            num_deleted_nodes: if sum == 0 {
                total_num_nodes
            } else {
                num_deleted_nodes
            },
        }
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

    let r = delete_tree_node(&graph, &value, root);
    r.total_num_nodes - r.num_deleted_nodes
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
    ); //
    println!(
        "{}",
        delete_tree_nodes(7, vec![-1, 0, 0, 1, 2, 2, 2], vec![0, 0, 0, 0, 0, 0, 0])
    ); // 2
}
