use std::collections::BinaryHeap;

// https://leetcode.com/problems/jump-game-vi/
pub fn max_result(nums: Vec<i32>, k: i32) -> i32 {
    // fn f(nums: &Vec<i32>, k: i32, index: i32, memo: &mut Vec<i32>) -> i32 {
    //     if index == nums.len() as i32 - 1 {
    //         return nums[index as usize];
    //     }
    //     if memo[index as usize] != i32::MIN {
    //         return memo[index as usize];
    //     }
    //     let mut max = i32::MIN;
    //     for i in (index + 1)..=(nums.len() as i32 - 1).min(index + k) {
    //         let mut x = f(nums, k, i, memo);
    //         if x != i32::MIN {
    //             x += nums[index as usize];
    //         }
    //         max = max.max(x);
    //     }
    //     memo[index as usize] = max;
    //     max
    // }
    //
    // f(&nums, k, 0, &mut vec![i32::MIN; nums.len()])

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
