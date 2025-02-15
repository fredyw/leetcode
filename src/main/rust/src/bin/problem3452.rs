// https://leetcode.com/problems/sum-of-good-numbers/description/
pub fn sum_of_good_numbers(nums: Vec<i32>, k: i32) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() {
        if (i as i32 - k < 0 || nums[i - k as usize] < nums[i])
            && (i + k as usize >= nums.len() || nums[i] > nums[i + k as usize])
        {
            answer += nums[i];
        }
    }
    answer
}

fn main() {
    println!("{}", sum_of_good_numbers(vec![1, 3, 2, 1, 5, 4], 2)); // 12
    println!("{}", sum_of_good_numbers(vec![2, 1], 1)); // 2
}
