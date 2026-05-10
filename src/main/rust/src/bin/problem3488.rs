use std::collections::HashMap;

// https://leetcode.com/problems/closest-equal-element-queries/description/
pub fn solve_queries(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
    let mut map: HashMap<i32, Vec<usize>> = HashMap::new();
    for (i, &num) in nums.iter().enumerate() {
        map.entry(num).or_insert(vec![]).push(i);
    }
    let mut answer = vec![-1; queries.len()];
    for (i, q) in queries.iter().enumerate() {
        let q = *q as usize;
        let num = nums[q];
        let indexes = map.get(&num).unwrap();
        if indexes.len() <= 1 {
            answer[i] = -1;
            continue;
        }
        let pos = indexes.binary_search(&q).unwrap();
        let prev_idx = if pos == 0 {
            indexes[indexes.len() - 1]
        } else {
            indexes[pos - 1]
        };
        let dist_left = if q > prev_idx {
            q - prev_idx
        } else {
            nums.len() - (prev_idx - q)
        };
        let next_idx = if pos == indexes.len() - 1 {
            indexes[0]
        } else {
            indexes[pos + 1]
        };
        let dist_right = if next_idx > q {
            next_idx - q
        } else {
            nums.len() - (q - next_idx)
        };
        answer[i] = dist_left.min(dist_right) as i32;
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        solve_queries(vec![1, 3, 1, 4, 1, 3, 2], vec![0, 3, 5])
    ); // [2,-1,3]
    println!("{:?}", solve_queries(vec![1, 2, 3, 4], vec![0, 1, 2, 3])); // [-1,-1,-1,-1]
}
