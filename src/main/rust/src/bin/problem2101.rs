use std::collections::HashSet;

// https://leetcode.com/problems/detonate-the-maximum-bombs/
pub fn maximum_detonation(bombs: Vec<Vec<i32>>) -> i32 {
    fn square(x: i64) -> i64 {
        x * x
    }

    fn distance(x1: i64, y1: i64, x2: i64, y2: i64) -> i64 {
        (square((x1 - x2).abs()) as f64 + square((y1 - y2).abs()) as f64).sqrt() as i64
    }

    fn within_range(x1: i64, y1: i64, r1: i64, x2: i64, y2: i64, r2: i64) -> bool {
        distance(x1, y1, x2, y2) < r1 + r2
    }

    todo!()
}

fn main() {
    println!("{}", maximum_detonation(vec![vec![2, 1, 3], vec![6, 1, 4]])); // 2
    println!(
        "{}",
        maximum_detonation(vec![vec![1, 1, 5], vec![10, 10, 5]])
    ); // 1
    println!(
        "{}",
        maximum_detonation(vec![
            vec![1, 2, 3],
            vec![2, 3, 1],
            vec![3, 4, 2],
            vec![4, 5, 3],
            vec![5, 6, 4]
        ])
    ); // 5
}
