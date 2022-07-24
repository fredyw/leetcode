use std::collections::HashMap;

// https://leetcode.com/problems/equal-row-and-column-pairs/
pub fn equal_pairs(grid: Vec<Vec<i32>>) -> i32 {
    let mut answer = 0;
    let mut map: HashMap<String, i32> = HashMap::new();
    let n = grid.len();
    for col in 0..n {
        let mut v: Vec<String> = vec![];
        for row in 0..n {
            v.push(grid[row][col].to_string());
        }
        let string = v.join(",");
        match map.get(&string) {
            Some(count) => map.insert(string, count + 1),
            None => map.insert(string, 1),
        };
    }
    for row in 0..n {
        let string = grid[row]
            .iter()
            .map(|a| a.to_string())
            .collect::<Vec<String>>()
            .join(",");
        match map.get(&string) {
            Some(count) => answer += count,
            None => (),
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        equal_pairs(vec![vec![3, 2, 1], vec![1, 7, 6], vec![2, 7, 7]])
    ); // 1
    println!(
        "{}",
        equal_pairs(vec![
            vec![3, 1, 2, 2],
            vec![1, 4, 4, 5],
            vec![2, 4, 2, 2],
            vec![2, 4, 2, 2]
        ])
    ); // 3
    println!("{}", equal_pairs(vec![vec![11, 1], vec![1, 11]])); // 2
}
