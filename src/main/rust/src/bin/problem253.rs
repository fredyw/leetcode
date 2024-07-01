use std::cmp::Reverse;
use std::collections::BinaryHeap;

// https://leetcode.com/problems/meeting-rooms-ii/description/
pub fn min_meeting_rooms(intervals: Vec<Vec<i32>>) -> i32 {
    let mut intervals: Vec<(i32, i32)> = intervals.into_iter().map(|v| (v[0], v[1])).collect();
    intervals.sort();
    let mut answer = 1;
    let mut heap: BinaryHeap<Reverse<i32>> = BinaryHeap::new();
    heap.push(Reverse(intervals[0].1));
    for i in 1..intervals.len() {
        if heap.peek().unwrap().0 > intervals[i].0 {
            answer += 1;
        } else {
            heap.pop();
        }
        heap.push(Reverse(intervals[i].1));
    }
    answer
}

fn main() {
    println!(
        "{}",
        min_meeting_rooms(vec![vec![0, 30], vec![5, 10], vec![15, 20]])
    ); // 2
    println!("{}", min_meeting_rooms(vec![vec![7, 10], vec![2, 4]])); // 1
    println!(
        "{}",
        min_meeting_rooms(vec![vec![9, 10], vec![4, 9], vec![4, 17]])
    ); // 2
    println!(
        "{}",
        min_meeting_rooms(vec![vec![6, 15], vec![13, 20], vec![6, 17]])
    ); // 3
    println!(
        "{}",
        min_meeting_rooms(vec![vec![6, 15], vec![13, 20], vec![6, 17], vec![20, 23]])
    ); // 3
    println!(
        "{}",
        min_meeting_rooms(vec![vec![2, 11], vec![6, 16], vec![11, 16]])
    ); // 2
    println!(
        "{}",
        min_meeting_rooms(vec![vec![2, 11], vec![6, 16], vec![11, 16], vec![13, 14]])
    ); // 3
    println!(
        "{}",
        min_meeting_rooms(vec![vec![1, 5], vec![8, 9], vec![8, 9]])
    ); // 2
    println!("{}", min_meeting_rooms(vec![vec![8, 9], vec![8, 9]])); // 2
    println!(
        "{}",
        min_meeting_rooms(vec![vec![8, 14], vec![12, 13], vec![6, 13], vec![1, 9]])
    ); // 3
}
