use std::cmp::Reverse;
use std::collections::BinaryHeap;

// https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
pub fn find_score(nums: Vec<i32>) -> i64 {
    let mut queue: BinaryHeap<Reverse<(i32, usize)>> = BinaryHeap::new();
    for (i, n) in nums.iter().enumerate() {
        queue.push(Reverse((*n, i)));
    }
    let mut answer: i64 = 0;
    let mut marked: Vec<bool> = vec![false; nums.len()];
    while let Some(e) = queue.pop() {
        let (n, i) = e.0;
        if marked[i] == true {
            continue;
        }
        answer += n as i64;
        marked[i] = true;
        if i != 0 {
            marked[i - 1] = true;
        }
        if i + 1 < nums.len() {
            marked[i + 1] = true;
        }
    }
    answer
}

fn main() {
    println!("{}", find_score(vec![2, 1, 3, 4, 5, 2])); // 7
    println!("{}", find_score(vec![2, 3, 5, 1, 3, 2])); // 5
}
