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

    0
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
