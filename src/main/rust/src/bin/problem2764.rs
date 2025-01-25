use std::collections::HashMap;

// https://leetcode.com/problems/is-array-a-preorder-of-some-binary-tree/description/
pub fn is_preorder(nodes: Vec<Vec<i32>>) -> bool {
    fn preorder(tree: &HashMap<i32, Vec<i32>>, root: i32, preorder_nodes: &mut Vec<i32>) {
        preorder_nodes.push(root);
        if let Some(children) = tree.get(&root) {
            for child in children.iter() {
                preorder(tree, *child, preorder_nodes);
            }
        }
    }

    let mut tree: HashMap<i32, Vec<i32>> = HashMap::new();
    let mut root = 0;
    for node in nodes.iter() {
        let id = node[0];
        let parent = node[1];
        if parent == -1 {
            root = id;
        }
        tree.entry(parent).or_insert(vec![]).push(id);
    }
    let mut preorder_nodes = vec![];
    preorder(&tree, root, &mut preorder_nodes);
    for i in 0..nodes.len() {
        if nodes[i][0] != preorder_nodes[i] {
            return false;
        }
    }
    true
}

fn main() {
    println!(
        "{}",
        is_preorder(vec![
            vec![0, -1],
            vec![1, 0],
            vec![2, 0],
            vec![3, 2],
            vec![4, 2]
        ])
    ); // true
    println!(
        "{}",
        is_preorder(vec![
            vec![0, -1],
            vec![1, 0],
            vec![2, 0],
            vec![3, 1],
            vec![4, 1]
        ])
    ); // false
}
