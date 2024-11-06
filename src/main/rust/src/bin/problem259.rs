// https://leetcode.com/problems/3sum-smaller/description/
pub fn three_sum_smaller(mut nums: Vec<i32>, target: i32) -> i32 {
    fn less_than_count(nums: &Vec<i32>, i: usize, target: i32) -> i32 {
        let mut left = i as i32;
        let mut right = nums.len() as i32;
        while left < right {
            let mid = left + (right - left) / 2;
            if nums[mid as usize] < target {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if right < i as i32 {
            0
        } else {
            right - i as i32
        }
    }

    let mut answer = 0;
    nums.sort();
    for i in 0..nums.len() {
        for j in i + 1..nums.len() {
            if j + 1 == nums.len() {
                continue;
            }
            let sum = nums[i] + nums[j];
            let x = target - sum;
            let count = less_than_count(&nums, j + 1, x);
            // println!("i: {}, j: {}, x: {}, count: {}", i, j, x, count);
            if count > 0 {
                answer += count;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", three_sum_smaller(vec![-2, 0, 1, 3], 2)); // 2
    println!("{}", three_sum_smaller(vec![], 0)); // 0
    println!("{}", three_sum_smaller(vec![0], 0)); // 0
    println!("{}", three_sum_smaller(vec![-2, 0, 1, 0, 3, -2], 2)); // 15
    println!("{}", three_sum_smaller(vec![-2, -2, 0, 0, 1, 3], 2)); // 15
    println!("{}", three_sum_smaller(vec![0, 0, 1, 3], 2)); // 1
    println!("{}", three_sum_smaller(vec![0, 0, 1], 2)); // 1
    println!("{}", three_sum_smaller(vec![-2, -2, 0, 1], 2)); // 4
    println!("{}", three_sum_smaller(vec![-2, 0, 1], 2)); // 1
    println!("{}", three_sum_smaller(vec![0, 0, 0], 0)); // 0
}
