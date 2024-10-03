use std::collections::HashMap;

// https://leetcode.com/problems/minimum-cost-to-convert-string-i/
pub fn minimum_cost(
    source: String,
    target: String,
    original: Vec<char>,
    changed: Vec<char>,
    cost: Vec<i32>,
) -> i64 {
    fn build_graph(
        original: &Vec<char>,
        changed: &Vec<char>,
        cost: &Vec<i32>,
    ) -> HashMap<char, Vec<(char, i32)>> {
        let mut graph = HashMap::new();
        for i in 0..original.len() {
            graph
                .entry(original[i])
                .or_insert(Vec::new())
                .push((changed[i], cost[i]));
        }
        graph
    }

    fn shortest_path(graph: &HashMap<char, Vec<(char, i32)>>, source: char) -> HashMap<char, i32> {
        todo!()
    }

    let mut answer = 0;
    let source: Vec<char> = source.chars().collect();
    let target: Vec<char> = target.chars().collect();
    let graph = build_graph(&original, &changed, &cost);
    let mut shortest_path_map: HashMap<char, HashMap<char, i32>> = HashMap::new();
    for i in 0..source.len() {
        if let Some(map) = shortest_path_map.get(&source[i]) {
            if let Some(cost) = map.get(&target[i]) {
                answer += *cost as i64;
            } else {
                return -1;
            }
        } else {
            let map = shortest_path(&graph, source[i]);
            if let Some(cost) = map.get(&target[i]) {
                answer += *cost as i64;
            } else {
                return -1;
            }
            shortest_path_map.insert(source[i], map);
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        minimum_cost(
            "abcd".to_string(),
            "acbe".to_string(),
            vec!['a', 'b', 'c', 'c', 'e', 'd'],
            vec!['b', 'c', 'b', 'e', 'b', 'e'],
            vec![2, 5, 5, 1, 2, 20],
        )
    ); // 28
    println!(
        "{}",
        minimum_cost(
            "aaaa".to_string(),
            "bbbb".to_string(),
            vec!['a', 'c'],
            vec!['c', 'b'],
            vec![1, 2],
        )
    ); // 12
    println!(
        "{}",
        minimum_cost(
            "abcd".to_string(),
            "abce".to_string(),
            vec!['a'],
            vec!['e'],
            vec![10000],
        )
    ); // -1
}
