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

    let mut heap: BinaryHeap<Reverse<i32>> = BinaryHeap::new();
    for &num in &nums {
        heap.push(Reverse(num));
    }
    let mut answer: Vec<i32> = Vec::new();
    let mut p = p;
    for query in &queries {
        let val = query[0];
        let key = query[1];
        heap.push(Reverse(val));
        let mut tmp: Vec<i32> = Vec::new();
        for _ in 0..heap.len() - (heap.len() - key as usize + 1) {
            tmp.push(heap.pop().unwrap().0);
            println!("tmp: {:?}", tmp);
            p = update_p(p as i64, heap.peek().unwrap().0 as i64, 1_000_000_007_i64) as i32;
            answer.push(p);
        }
        for v in tmp {
            heap.push(Reverse(v));
        }
        if heap.len() >= 10 {
            heap.pop();
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        power_update(vec![2], 4, vec![vec![3, 1], vec![1, 2]])
    ); // [64,4096]
    // println!(
    //     "{:?}",
    //     power_update(vec![7, 5], 6, vec![vec![4, 3], vec![7, 2]])
    // ); // [1296,220296870]
}
