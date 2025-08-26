use std::collections::HashMap;

// https://leetcode.com/problems/maximum-weight-in-two-bags/description/
pub fn max_weight(weights: Vec<i32>, w1: i32, w2: i32) -> i32 {
    fn max_weight(
        weights: &Vec<i32>,
        w1: i32,
        w2: i32,
        index: usize,
        memo: &mut HashMap<(usize, i32, i32), i32>,
    ) -> i32 {
        if index == weights.len() {
            return 0;
        }
        if let Some(v) = memo.get(&(index, w1, w2)) {
            return *v;
        }
        let a = max_weight(weights, w1, w2, index + 1, memo);
        let b = if w1 - weights[index] >= 0 {
            max_weight(weights, w1 - weights[index], w2, index + 1, memo) + weights[index]
        } else {
            0
        };
        let c = if w2 - weights[index] >= 0 {
            max_weight(weights, w1, w2 - weights[index], index + 1, memo) + weights[index]
        } else {
            0
        };
        let max = a.max(b).max(c);
        memo.insert((index, w1, w2), max);
        max
    }

    max_weight(&weights, w1, w2, 0, &mut HashMap::new())
}

fn main() {
    println!("{}", max_weight(vec![1, 4, 3, 2], 5, 4)); // 9
    println!("{}", max_weight(vec![3, 6, 4, 8], 9, 7)); // 15
    println!("{}", max_weight(vec![5, 7], 2, 3)); // 0
    println!("{}", max_weight(vec![1, 1, 1], 13, 4)); // 3
}
