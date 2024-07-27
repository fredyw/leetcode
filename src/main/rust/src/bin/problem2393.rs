// https://leetcode.com/problems/count-strictly-increasing-subarrays/
pub fn count_subarrays(nums: Vec<i32>) -> i64 {
    let mut answer = 0;
    let mut sum = 1;
    for i in 0..nums.len() - 1 {
        if nums[i] < nums[i + 1] {
            answer += sum;
            sum += 1;
        } else {
            answer += sum;
            sum = 1;
        }
    }
    answer += sum;
    answer
}

fn main() {
    println!("{}", count_subarrays(vec![1, 3, 5, 4, 4, 6])); // 10
    println!("{}", count_subarrays(vec![1, 2, 3, 4, 5])); // 15
}
