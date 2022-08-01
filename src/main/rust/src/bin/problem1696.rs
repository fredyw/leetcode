use std::collections::BinaryHeap;

// https://leetcode.com/problems/jump-game-vi/
pub fn max_result(nums: Vec<i32>, k: i32) -> i32 {
    let mut dp = vec![i32::MIN; nums.len()];
    dp[0] = nums[0];
    let mut heap: BinaryHeap<(i32, i32)> = BinaryHeap::new();
    heap.push((dp[0], 0));
    for i in 1..nums.len() {
        while !heap.is_empty() && i as i32 - (*heap.peek().unwrap()).1 > k {
            heap.pop();
        }
        let max = heap.peek().unwrap();
        dp[i] = dp[i].max(nums[i] + dp[max.1 as usize]);
        heap.push((dp[i], i as i32));
    }
    dp[dp.len() - 1]
}

fn main() {
    println!("{}", max_result(vec![1, -1, -2, 4, -7, 3], 2)); // 7
    println!("{}", max_result(vec![10, -5, -2, 4, 0, 3], 3)); // 17
    println!("{}", max_result(vec![1, -5, -20, 4, -1, 3, -6, -3], 2)); // 0
    println!("{}", max_result(vec![3, -6, -3], 2)); // 0
}
