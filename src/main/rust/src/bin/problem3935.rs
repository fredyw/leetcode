use std::cmp::Reverse;
use std::collections::BinaryHeap;

// https://leetcode.com/problems/power-update-after-k-th-largest-insertion-i/description/
pub fn power_update(nums: Vec<i32>, p: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
    fn update_p(current_p: i64, mut x: i64, modulus: i64) -> i64 {
        let mut result = 1;
        let mut base = current_p % modulus;
        while x > 0 {
            if x % 2 == 1 {
                result = (result * base) % modulus;
            }
            base = (base * base) % modulus;
            x /= 2;
        }
        result
    }

    let mut top_k: BinaryHeap<Reverse<i32>> = BinaryHeap::new();
    let mut leftovers: BinaryHeap<i32> = BinaryHeap::new();
    for &num in &nums {
        leftovers.push(num);
    }
    let mut answer: Vec<i32> = Vec::new();
    let mut p = p;
    for query in &queries {
        let val = query[0];
        let key = query[1] as usize;
        if let Some(&Reverse(current_min_top)) = top_k.peek() {
            if val > current_min_top {
                top_k.push(Reverse(val));
            } else {
                leftovers.push(val);
            }
        } else {
            leftovers.push(val);
        }
        while top_k.len() < key {
            if let Some(left_max) = leftovers.pop() {
                top_k.push(Reverse(left_max));
            }
        }
        while top_k.len() > key {
            if let Some(Reverse(top_min)) = top_k.pop() {
                leftovers.push(top_min);
            }
        }
        let k_largest = top_k.peek().unwrap().0 as i64;
        p = update_p(p as i64, k_largest, 1_000_000_007_i64) as i32;
        answer.push(p);
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        power_update(vec![2], 4, vec![vec![3, 1], vec![1, 2]])
    ); // [64,4096]
    println!(
        "{:?}",
        power_update(vec![7, 5], 6, vec![vec![4, 3], vec![7, 2]])
    ); // [1296,220296870]
}
