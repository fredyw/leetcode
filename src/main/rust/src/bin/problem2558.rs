use std::collections::BinaryHeap;

// https://leetcode.com/problems/take-gifts-from-the-richest-pile/
pub fn pick_gifts(gifts: Vec<i32>, k: i32) -> i64 {
    let mut queue: BinaryHeap<i32> = gifts.into_iter().collect();
    for _ in 0..k {
        let n = (queue.pop().unwrap() as f64).sqrt() as i32;
        queue.push(n);
    }
    queue.into_iter().map(|n| n as i64).sum()
}

fn main() {
    println!("{}", pick_gifts(vec![25, 64, 9, 4, 100], 4)); // 29
    println!("{}", pick_gifts(vec![1, 1, 1, 1], 4)); // 4
}
