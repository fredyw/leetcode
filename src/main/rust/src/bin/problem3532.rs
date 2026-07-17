use std::collections::HashMap;

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
    let mut group = 0;
    let mut connected: HashMap<usize, i32> = HashMap::new();
    for i in 0..nums.len() - 1 {
        if (nums[i] - nums[i + 1]).abs() <= max_diff {
            connected.insert(i, group);
            connected.insert(i + 1, group);
        } else {
            connected.insert(i, group);
            group += 1;
            if i + 1 == nums.len() - 1 {
                connected.insert(i + 1, group);
            }
        }
    }
    let mut answer = Vec::new();
    for query in queries {
        let (u, v) = (query[0] as usize, query[1] as usize);
        answer.push(connected.get(&u).unwrap() == connected.get(&v).unwrap());
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        path_existence_queries(2, vec![1, 3], 1, vec![vec![0, 0], vec![0, 1]])
    ); // [true,false]
    println!(
        "{:?}",
        path_existence_queries(
            4,
            vec![2, 5, 6, 8],
            2,
            vec![vec![0, 1], vec![0, 2], vec![1, 3], vec![2, 3]]
        )
    ); // [false,false,true,true]
    println!(
        "{:?}",
        path_existence_queries(1, vec![10], 1, vec![vec![0, 0]])
    ); // [true]
    println!(
        "{:?}",
        path_existence_queries(2, vec![25868, 59061], 0, vec![vec![1, 1]])
    ); // [true]
}
