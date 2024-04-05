use std::collections::VecDeque;

// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/
pub fn count_subarrays(nums: Vec<i32>, k: i32) -> i64 {
    fn count_subarrays(nums: &Vec<i32>, begin: i64, left: i64, right: i64) -> i64 {
        // [1, 3, 2, 3, 3]
        //
        // left: 1, right: 3
        // a: [3, 2, 3], [3, 2, 3, 3] --> 2
        // b: [1, 3, 2, 3], [1, 3, 2, 3, 3] --> 2
        //
        // left: 3, right: 4
        // a: [3, 3] --> 1
        // b: [2, 3, 3] --> 1
        //
        // total: 2 + 2 + 1 + 1 = 6
        //
        // a: the number of elements from right all the way to the end.
        let a = nums.len() as i64 - right;
        // b: a * the number of elements from begin to the left
        let b = a * (left - begin - 1);
        a + b
    }

    let mut answer = 0;
    let max = nums.iter().max().unwrap();
    let mut deque: VecDeque<usize> = VecDeque::new();
    let mut begin: i64 = -1;
    for (i, num) in nums.iter().enumerate() {
        if num == max {
            deque.push_back(i);
            if deque.len() as i32 == k {
                let left = *deque.front().unwrap() as i64;
                let right = *deque.back().unwrap() as i64;
                answer += count_subarrays(&nums, begin, left, right);
                begin = left;
                deque.pop_front();
            }
        }
    }
    answer
}

fn main() {
    println!("{}", count_subarrays(vec![1, 3, 2, 3, 3], 2)); // 6
    println!("{}", count_subarrays(vec![1, 4, 2, 1], 3)); // 0
    println!("{}", count_subarrays(vec![2, 1, 3, 2, 3, 1, 1], 2)); // 9
    println!("{}", count_subarrays(vec![2, 1, 3, 2, 3, 1, 1, 1], 2)); // 12
    println!(
        "{}",
        count_subarrays(
            vec![28, 5, 58, 91, 24, 91, 53, 9, 48, 85, 16, 70, 91, 91, 47, 91, 61, 4, 54, 61, 49],
            1
        )
    ); // 187
}
