use std::collections::HashSet;

// https://leetcode.com/problems/path-existence-queries-in-a-graph-i/description/
pub fn path_existence_queries(
    n: i32,
    nums: Vec<i32>,
    max_diff: i32,
    queries: Vec<Vec<i32>>,
) -> Vec<bool> {
    if n == 1 {
        return vec![true; queries.len()];
    }
    let mut connected: Vec<HashSet<usize>> = vec![];
    let mut set = HashSet::new();
    for i in 0..nums.len() - 1 {
        if (nums[i] - nums[i + 1]).abs() <= max_diff {
            set.insert(i);
            set.insert(i + 1);
        } else {
            set.insert(i);
            connected.push(set);
            set = HashSet::new();
        }
    }
    if !set.is_empty() {
        connected.push(set);
    }
    println!("{:?}", connected);
    let mut answer = Vec::new();
    for query in queries {
        let (u, v) = (query[0] as usize, query[1] as usize);
        let mut is_connected = false;
        for conn in &connected {
            is_connected = conn.contains(&u) && conn.contains(&v);
            if is_connected {
                break;
            }
        }
        answer.push(is_connected);
    }
    answer
}

fn main() {
    // println!(
    //     "{:?}",
    //     path_existence_queries(2, vec![1, 3], 1, vec![vec![0, 0], vec![0, 1]])
    // ); // [true,false]
    // println!(
    //     "{:?}",
    //     path_existence_queries(
    //         4,
    //         vec![2, 5, 6, 8],
    //         2,
    //         vec![vec![0, 1], vec![0, 2], vec![1, 3], vec![2, 3]]
    //     )
    // ); // [false,false,true,true]
    // println!(
    //     "{:?}",
    //     path_existence_queries(1, vec![10], 1, vec![vec![0, 0]])
    // ); // [true]
    println!(
        "{:?}",
        path_existence_queries(2, vec![25868, 59061], 0, vec![vec![1, 1]])
    ); // [true]
}
