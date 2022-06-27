use std::cmp;
use std::cmp::Reverse;
use std::collections::BinaryHeap;

// https://leetcode.com/problems/two-best-non-overlapping-events/
pub fn max_two_events(mut events: Vec<Vec<i32>>) -> i32 {
    events.sort_by(|a, b| {
        let start_time1 = &a[0];
        let end_time1 = &a[1];
        let start_time2 = &b[0];
        let end_time2 = &b[1];
        let o = start_time1.cmp(start_time2);
        if o.is_eq() {
            end_time1.cmp(end_time2)
        } else {
            o
        }
    });
    let mut answer = 0;
    let mut max = 0;
    let mut heap: BinaryHeap<(Reverse<i32>, Reverse<i32>)> = BinaryHeap::new();
    for i in 0..events.len() {
        let start_time = &events[i][0];
        let end_time = &events[i][1];
        let value = &events[i][2];
        while !heap.is_empty() {
            if heap.peek().unwrap().0 .0 >= *start_time {
                break;
            }
            max = cmp::max(max, heap.pop().unwrap().1 .0);
        }
        answer = cmp::max(answer, max + value);
        heap.push((Reverse(*end_time), Reverse(*value)));
    }
    answer
}

fn main() {
    println!(
        "{}",
        max_two_events(vec![vec![1, 3, 2], vec![4, 5, 2], vec![2, 4, 3]])
    ); // 4
    println!(
        "{}",
        max_two_events(vec![vec![1, 3, 2], vec![4, 5, 2], vec![1, 5, 5]])
    ); // 5
    println!(
        "{}",
        max_two_events(vec![vec![1, 5, 3], vec![1, 5, 1], vec![6, 6, 5]])
    ); // 8
    println!(
        "{}",
        max_two_events(vec![
            vec![10, 83, 53],
            vec![63, 87, 45],
            vec![97, 100, 32],
            vec![51, 61, 16]
        ])
    ); // 85
}
