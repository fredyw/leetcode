// https://leetcode.com/problems/maximum-strong-pair-xor-i/description/
pub fn maximum_strong_pair_xor(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() {
        for j in i..nums.len() {
            if (nums[i] - nums[j]).abs() <= nums[i].min(nums[j]) {
                answer = answer.max(nums[i] ^ nums[j]);
            }
        }
    }
    answer
}

fn main() {
    println!("{}", maximum_strong_pair_xor(vec![1, 2, 3, 4, 5])); // 7
    println!("{}", maximum_strong_pair_xor(vec![10, 100])); // 0
    println!("{}", maximum_strong_pair_xor(vec![5, 6, 25, 30])); // 7
}
