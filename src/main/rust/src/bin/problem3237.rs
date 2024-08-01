use std::collections::HashSet;

// https://leetcode.com/problems/alt-and-tab-simulation/description/
pub fn simulation_result(windows: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![];
    let mut set: HashSet<i32> = HashSet::new();
    for i in (0..queries.len()).rev() {
        if !set.contains(&queries[i]) {
            answer.push(queries[i]);
            set.insert(queries[i]);
        }
    }
    for i in 0..windows.len() {
        if !set.contains(&windows[i]) {
            answer.push(windows[i]);
        }
    }
    answer
}

fn main() {
    println!("{:?}", simulation_result(vec![1, 2, 3], vec![3, 3, 2])); // [2,3,1]
    println!("{:?}", simulation_result(vec![1, 4, 2, 3], vec![4, 1, 3])); // [3,1,4,2]
}
