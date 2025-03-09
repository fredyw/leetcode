use std::collections::HashMap;

// https://leetcode.com/problems/find-subtree-sizes-after-changes/
pub fn find_subtree_sizes(mut parent: Vec<i32>, s: String) -> Vec<i32> {
    fn build_tree(parent: &Vec<i32>) -> Vec<Vec<usize>> {
        let mut graph: Vec<Vec<usize>> = vec![vec![]; parent.len()];
        for (i, p) in parent.iter().enumerate() {
            if *p != -1 {
                graph[*p as usize].push(i);
            }
        }
        graph
    }

    fn update_parents(
        tree: &Vec<Vec<usize>>,
        chars: &Vec<char>,
        node: usize,
        parents: &mut Vec<i32>,
        last_seen: &mut HashMap<char, usize>,
    ) {
        let c = chars[node];
        if let Some(n) = last_seen.get(&c) {
            parents[node] = *n as i32;
        }
        let original = last_seen.insert(c, node);
        for adj in tree[node].iter() {
            update_parents(tree, chars, *adj, parents, last_seen);
        }
        if let Some(n) = original {
            last_seen.insert(c, n);
        } else {
            last_seen.remove(&c);
        }
    }

    fn count_subtree_sizes(tree: &Vec<Vec<usize>>, node: usize, answer: &mut Vec<i32>) -> i32 {
        let mut size = 1;
        for adj in tree[node].iter() {
            size += count_subtree_sizes(tree, *adj, answer);
        }
        answer[node] = size;
        size
    }

    let tree: Vec<Vec<usize>> = build_tree(&parent);
    let chars: Vec<char> = s.chars().collect();
    update_parents(&tree, &chars, 0, &mut parent, &mut HashMap::new());
    let tree = build_tree(&parent); // update the graph
    let mut answer = vec![0; parent.len()];
    count_subtree_sizes(&tree, 0, &mut answer);
    answer
}

fn main() {
    println!(
        "{:?}",
        find_subtree_sizes(vec![-1, 0, 0, 1, 1, 1], "abaabc".to_string())
    ); // [6,3,1,1,1,1]
    println!(
        "{:?}",
        find_subtree_sizes(vec![-1, 0, 4, 0, 1], "abbba".to_string())
    ); // [5,2,1,1,1]
    println!(
        "{:?}",
        find_subtree_sizes(vec![-1, 0, 0, 1, 1, 1, 3], "abaabcb".to_string())
    ); // [7,4,1,1,1,1,1]
    println!(
        "{:?}",
        find_subtree_sizes(vec![-1, 0, 1], "aaa".to_string())
    ); // [3,2,1]
    println!(
        "{:?}",
        find_subtree_sizes(vec![-1, 0, 1, 2, 3], "abcbd".to_string())
    ); // [5,4,1,2,1]
    println!(
        "{:?}",
        find_subtree_sizes(vec![-1, 0, 1, 2], "abab".to_string())
    ); // [4,2,1,1]
}
