use std::cmp::Reverse;
use std::collections::BinaryHeap;

// https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/
pub fn get_final_state(mut nums: Vec<i32>, k: i32, multiplier: i32) -> Vec<i32> {
    let mut heap: BinaryHeap<Reverse<(i32, usize)>> = BinaryHeap::new();
    for (i, num) in nums.iter().enumerate() {
        heap.push(Reverse((*num, i)));
    }
    for _ in 0..k {
        let (n, i) = heap.pop().unwrap().0;
        nums[i] *= multiplier;
        heap.push(Reverse((nums[i], i)));
    }
    nums
}

fn main() {
    println!("{:?}", get_final_state(vec![2, 1, 3, 5, 6], 5, 2)); // [8,4,6,5,6]
    println!("{:?}", get_final_state(vec![1, 2], 3, 4)); // [16,8]
}
