// https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/
pub fn count_subarrays(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() - 2 {
        if nums[i] + nums[i + 2] == nums[i + 1] / 2 && nums[i + 1] % 2 == 0 {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", count_subarrays(vec![1, 2, 1, 4, 1])); // 1
    println!("{}", count_subarrays(vec![1, 1, 1])); // 0
    println!("{}", count_subarrays(vec![-1, -4, -1, 4])); // 1
}
