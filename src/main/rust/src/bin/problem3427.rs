// https://leetcode.com/problems/sum-of-variable-length-subarrays/description/
pub fn subarray_sum(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() {
        let start = 0.max(i as i32 - nums[i]) as usize;
        answer += &nums[start..=i].iter().sum();
    }
    answer
}

fn main() {
    println!("{}", subarray_sum(vec![2, 3, 1])); // 11
    println!("{}", subarray_sum(vec![3, 1, 1, 2])); // 13
}
