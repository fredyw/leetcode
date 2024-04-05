use std::collections::VecDeque;

// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/
pub fn count_subarrays(nums: Vec<i32>, k: i32) -> i64 {
    fn count_subarrays(nums: &Vec<i32>, left: usize, right: usize) -> i64 {
        let b = nums.len() as i64 - right as i64;
        let a = b * left as i64;
        a + b
    }

    let mut answer = 0;
    let max = nums.iter().max().unwrap();
    let mut deque: VecDeque<usize> = VecDeque::new();
    for (i, num) in nums.iter().enumerate() {
        if num == max {
            deque.push_back(i);
            if deque.len() as i32 == k {
                let left = deque.pop_front().unwrap();
                let right = *deque.back().unwrap();
                answer += count_subarrays(&nums, left, right);
            }
        }
    }
    answer
}

fn main() {
    println!("{}", count_subarrays(vec![1, 3, 2, 3, 3], 2)); // 6
                                                             // println!("{}", count_subarrays(vec![1, 4, 2, 1], 3)); // 0
                                                             // println!("{}", count_subarrays(vec![2, 1, 3, 2, 3, 1, 1], 2)); // 9
                                                             // println!("{}", count_subarrays(vec![2, 1, 3, 2, 3, 1, 1, 1], 2)); // 12
}
