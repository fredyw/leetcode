use std::collections::HashMap;

// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
pub fn min_score(n: i32, roads: Vec<Vec<i32>>) -> i32 {
    fn dfs(
        adj_list: &HashMap<i32, Vec<(i32, i32)>>,
        visited: &mut Vec<bool>,
        n: i32,
        min: &mut i32,
    ) {
        visited[n as usize] = true;
        for (adj, distance) in adj_list.get(&n).unwrap_or(&vec![]).into_iter() {
            *min = (*min).min(*distance);
            if visited[*adj as usize] {
                continue;
            }
            dfs(adj_list, visited, *adj, min);
        }
    }

    let mut adj_list: HashMap<i32, Vec<(i32, i32)>> = HashMap::new();
    for road in roads.into_iter() {
        adj_list
            .entry(road[0])
            .or_insert(vec![])
            .push((road[1], road[2]));
        adj_list
            .entry(road[1])
            .or_insert(vec![])
            .push((road[0], road[2]));
    }
    let mut answer = i32::MAX;
    let mut visited: Vec<bool> = vec![false; (n + 1) as usize];
    dfs(&adj_list, &mut visited, 1, &mut answer);
    answer
}

fn main() {
    println!(
        "{}",
        min_score(
            4,
            vec![vec![1, 2, 9], vec![2, 3, 6], vec![2, 4, 5], vec![1, 4, 7]]
        )
    ); // 5
    println!(
        "{}",
        min_score(
            4,
            vec![vec![1, 2, 9], vec![2, 3, 3], vec![2, 4, 6], vec![1, 4, 7]]
        )
    ); // 3
    println!(
        "{}",
        min_score(4, vec![vec![1, 2, 2], vec![1, 3, 4], vec![3, 4, 7]])
    ); // 2
    println!(
        "{}",
        min_score(
            6,
            vec![
                vec![4, 5, 7468],
                vec![6, 2, 7173],
                vec![6, 3, 8365],
                vec![2, 3, 7674],
                vec![5, 6, 7852],
                vec![1, 2, 8547],
                vec![2, 4, 1885],
                vec![2, 5, 5192],
                vec![1, 3, 4065],
                vec![1, 4, 7357]
            ]
        )
    ); // 1885
}
