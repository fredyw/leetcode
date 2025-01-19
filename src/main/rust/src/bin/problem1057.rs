use std::cmp::Reverse;
use std::collections::BinaryHeap;

// https://leetcode.com/problems/campus-bikes/description/
pub fn assign_bikes(workers: Vec<Vec<i32>>, bikes: Vec<Vec<i32>>) -> Vec<i32> {
    fn manhattan(x1: i32, y1: i32, x2: i32, y2: i32) -> i32 {
        (x1 - x2).abs() + (y1 - y2).abs()
    }

    let mut worker_bikes: Vec<BinaryHeap<Reverse<(i32, usize)>>> =
        vec![BinaryHeap::new(); workers.len()];
    for i in 0..workers.len() {
        for j in 0..bikes.len() {
            let distance = manhattan(workers[i][0], workers[i][1], bikes[j][0], bikes[j][1]);
            worker_bikes[i].push(Reverse((distance, j)));
        }
    }
    let mut answer = vec![0; workers.len()];
    answer
}

fn main() {
    println!(
        "{:?}",
        assign_bikes(vec![vec![0, 0], vec![2, 1]], vec![vec![1, 2], vec![3, 3]])
    ); // [1,0]
    println!(
        "{:?}",
        assign_bikes(
            vec![vec![0, 0], vec![1, 1], vec![2, 0]],
            vec![vec![1, 0], vec![2, 2], vec![2, 1]]
        )
    ); // [0,2,1]
}
