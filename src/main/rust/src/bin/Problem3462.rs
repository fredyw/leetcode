use std::collections::BinaryHeap;

// https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/description/
pub fn max_sum(mut grid: Vec<Vec<i32>>, limits: Vec<i32>, k: i32) -> i64 {
    for i in 0..grid.len() {
        grid[i].sort_by(|a, b| b.cmp(a));
    }
    let mut heap: BinaryHeap<i32> = BinaryHeap::new();
    for (i, g) in grid.iter().enumerate() {
        for j in 0..limits[i] {
            heap.push(g[j as usize]);
        }
    }
    let mut answer: i64 = 0;
    for _ in 0..k {
        answer += heap.pop().unwrap() as i64;
    }
    answer
}

fn main() {
    println!("{}", max_sum(vec![vec![1, 2], vec![3, 4]], vec![1, 2], 2)); // 7
    println!(
        "{}",
        max_sum(vec![vec![5, 3, 7], vec![8, 2, 6]], vec![2, 2], 3)
    ); // 21
    println!(
        "{}",
        max_sum(
            vec![vec![7, 5, 3], vec![8, 6, 2], vec![9, 5, 4], vec![10, 9, 7]],
            vec![2, 1, 3, 2],
            6
        )
    ); // 48
}
