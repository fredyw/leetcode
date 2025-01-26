// https://leetcode.com/problems/count-partitions-with-even-sum-difference/description/
pub fn count_partitions(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let total_sum: i32 = nums.iter().sum();
    let mut left_sum = 0;
    for i in 0..nums.len() - 1 {
        left_sum += nums[i];
        let right_sum = total_sum - left_sum;
        if (left_sum - right_sum) % 2 == 0 {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", count_partitions(vec![10, 10, 3, 7, 6])); // 4
    println!("{}", count_partitions(vec![1, 2, 2])); // 0
    println!("{}", count_partitions(vec![2, 4, 6, 8])); // 3
}
