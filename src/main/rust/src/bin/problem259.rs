// https://leetcode.com/problems/3sum-smaller/description/
pub fn three_sum_smaller(mut nums: Vec<i32>, target: i32) -> i32 {
    fn less_than_count(nums: &Vec<i32>, start: usize, target: i32) -> i32 {
        let mut left = start as i32;
        let mut right = nums.len() as i32;
        while left <= right {
            let mid = left + (right - left) / 2;
            if mid >= nums.len() as i32 {
                break;
            }
            if nums[mid as usize] < target {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if right < start as i32 {
            0
        } else if right >= nums.len() as i32 {
            nums.len() as i32 - start as i32
        } else {
            right - start as i32 + 1
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
            answer += less_than_count(&nums, j + 1, x);
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
    println!("{}", three_sum_smaller(vec![1, -1, 2, 0, 3, -2], 2)); // 10
    println!("{}", three_sum_smaller(vec![-2, -1, 0, 1, 2, 3], 2)); // 10
    println!("{}", three_sum_smaller(vec![-4, -1, -1, 0, 1, 2], -5)); // 1
}
