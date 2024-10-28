use std::cmp::Reverse;
use std::collections::{BinaryHeap, HashMap};

// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/
pub fn smallest_chair(times: Vec<Vec<i32>>, target_friend: i32) -> i32 {
    let mut times: Vec<(i32, i32, usize)> = times
        .into_iter()
        .enumerate()
        .map(|(i, t)| (t[0], t[1], i))
        .collect();
    times.sort_by(|a, b| a.0.cmp(&b.0));
    let mut leaving_heap: BinaryHeap<Reverse<(i32, usize)>> = BinaryHeap::new();
    let mut friend_to_chair_map: HashMap<usize, i32> = HashMap::new();
    for (arrival, leaving, friend) in times.iter() {
        if leaving_heap.is_empty() {
        } else {
        }
    }
    *friend_to_chair_map.get(&(target_friend as usize)).unwrap()
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
    println!(
        "{}",
        smallest_chair(vec![vec![1, 4], vec![2, 3], vec![5, 6]], 1)
    ); // 0
}
