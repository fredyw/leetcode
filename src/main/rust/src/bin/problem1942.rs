use std::cmp::Reverse;
use std::collections::BinaryHeap;

// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/
pub fn smallest_chair(mut times: Vec<Vec<i32>>, target_friend: i32) -> i32 {
    times.sort_by(|a, b| a[0].cmp(&b[0]));
    let mut heap: BinaryHeap<Reverse<(i32, usize)>> = BinaryHeap::new();
    for (i, t) in times.iter().enumerate() {
        let arrival = t[0];
        let leaving = t[1];
    }
    todo!()
}

fn main() {
    println!(
        "{}",
        smallest_chair(vec![vec![1, 4], vec![2, 3], vec![4, 6]], 1)
    ); // 1
    println!(
        "{}",
        smallest_chair(vec![vec![3, 10], vec![1, 5], vec![2, 6]], 0)
    ); // 2
}
