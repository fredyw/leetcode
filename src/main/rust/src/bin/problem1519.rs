use std::collections::HashMap;

// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
pub fn count_sub_trees(n: i32, edges: Vec<Vec<i32>>, labels: String) -> Vec<i32> {
    fn count_sub_trees(
        node: i32,
        graph: &HashMap<i32, Vec<i32>>,
        labels: &Vec<char>,
        visited: &mut Vec<bool>,
        answer: &mut Vec<i32>,
    ) -> Vec<i32> {
        visited[node as usize] = true;
        let c = labels[node as usize];
        let mut v: Vec<i32> = vec![0; 26];
        for child in graph.get(&node).unwrap_or(&vec![]).into_iter() {
            if visited[*child as usize] {
                continue;
            }
            for (i, n) in count_sub_trees(*child, graph, labels, visited, answer)
                .into_iter()
                .enumerate()
            {
                v[i] += n;
            }
        }
        v[c as usize - ('a' as usize)] += 1;
        answer[node as usize] = v[c as usize - ('a' as usize)];
        return v;
    }

    let mut graph: HashMap<i32, Vec<i32>> = HashMap::new();
    let labels: Vec<char> = labels.chars().collect();
    for edge in edges.into_iter() {
        let from = edge[0];
        let to = edge[1];
        (*graph.entry(from).or_insert(vec![])).push(to);
        (*graph.entry(to).or_insert(vec![])).push(from);
    }
    let mut answer = vec![0; n as usize];
    let mut visited = vec![false; n as usize];
    count_sub_trees(0, &graph, &labels, &mut visited, &mut answer);
    answer
}

fn main() {
    println!(
        "{:?}",
        count_sub_trees(
            7,
            vec![
                vec![0, 1],
                vec![0, 2],
                vec![1, 4],
                vec![1, 5],
                vec![2, 3],
                vec![2, 6]
            ],
            "abaedcd".to_string()
        )
    ); // [2,1,1,1,1,1,1]
    println!(
        "{:?}",
        count_sub_trees(
            4,
            vec![vec![0, 1], vec![1, 2], vec![0, 3]],
            "bbbb".to_string()
        )
    ); // [4,2,1,1]
    println!(
        "{:?}",
        count_sub_trees(
            5,
            vec![vec![0, 1], vec![0, 2], vec![1, 3], vec![0, 4]],
            "aabab".to_string()
        )
    ); // [3,2,1,1,1]
    println!(
        "{:?}",
        count_sub_trees(
            4,
            vec![vec![0, 2], vec![0, 3], vec![1, 2]],
            "aeed".to_string()
        )
    ); // [1,1,2,1]
}
