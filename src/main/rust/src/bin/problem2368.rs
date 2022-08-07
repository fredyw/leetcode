use std::collections::HashSet;
use std::iter::FromIterator;

// https://leetcode.com/problems/reachable-nodes-with-restrictions/
pub fn reachable_nodes(n: i32, edges: Vec<Vec<i32>>, restricted: Vec<i32>) -> i32 {
    fn build_adj_list(n: i32, edges: &Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut adj_list = vec![vec![]; n as usize];
        for edge in edges.into_iter() {
            if let Some(v) = adj_list.get_mut(edge[0] as usize) {
                v.push(edge[1]);
            }
            if let Some(v) = adj_list.get_mut(edge[1] as usize) {
                v.push(edge[0]);
            }
        }
        adj_list
    }

    fn num_reachable(
        adj_list: &Vec<Vec<i32>>,
        restricted: &HashSet<i32>,
        visited: &mut HashSet<i32>,
        num: i32,
    ) -> i32 {
        if visited.contains(&num) || restricted.contains(&num) {
            return 0;
        }
        visited.insert(num);
        let mut count = 1;
        for adjacent in adj_list.get(num as usize).unwrap_or(&vec![]) {
            count += num_reachable(adj_list, restricted, visited, *adjacent);
        }
        count
    }

    let adj_list = build_adj_list(n, &edges);
    let restricted: HashSet<i32> = HashSet::from_iter(restricted.into_iter());
    num_reachable(&adj_list, &restricted, &mut HashSet::new(), 0)
}

fn main() {
    println!(
        "{}",
        reachable_nodes(
            7,
            vec![
                vec![0, 1],
                vec![1, 2],
                vec![3, 1],
                vec![4, 0],
                vec![0, 5],
                vec![5, 6]
            ],
            vec![4, 5]
        )
    ); // 4
    println!(
        "{}",
        reachable_nodes(
            7,
            vec![
                vec![0, 1],
                vec![0, 2],
                vec![0, 5],
                vec![0, 4],
                vec![3, 2],
                vec![6, 5]
            ],
            vec![4, 2, 1]
        )
    ); // 3
}
