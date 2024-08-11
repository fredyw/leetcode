use std::cmp::Reverse;
use std::collections::BinaryHeap;

// https://leetcode.com/problems/minimum-cost-to-connect-sticks/description/
pub fn connect_sticks(sticks: Vec<i32>) -> i32 {
    let mut heap: BinaryHeap<Reverse<i32>> = BinaryHeap::new();
    for stick in sticks {
        heap.push(Reverse(stick));
    }
    let mut answer = 0;
    while !heap.is_empty() {
        let a = heap.pop().unwrap().0;
        if heap.is_empty() {
            break;
        }
        let b = heap.pop().unwrap().0;
        answer += a + b;
        heap.push(Reverse(a + b));
    }
    answer
}

fn main() {
    println!("{}", connect_sticks(vec![2, 4, 3])); // 14
    println!("{}", connect_sticks(vec![1, 8, 3, 5])); // 30
    println!("{}", connect_sticks(vec![5])); // 0
}
