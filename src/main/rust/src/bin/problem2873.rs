// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/
pub fn maximum_triplet_value(nums: Vec<i32>) -> i64 {
    let mut answer = 0;
    for i in 0..nums.len() {
        for j in i + 1..nums.len() {
            for k in j + 1..nums.len() {
                answer = answer.max((nums[i] as i64 - nums[j] as i64) * nums[k] as i64);
            }
        }
    }
    answer
}

fn main() {
    println!("{}", maximum_triplet_value(vec![12, 6, 1, 2, 7])); // 77
    println!("{}", maximum_triplet_value(vec![1, 10, 3, 4, 19])); // 133
    println!("{}", maximum_triplet_value(vec![1, 2, 3])); // 0
    println!("{}", maximum_triplet_value(vec![5, 4, 3, 2, 1])); // 4
    println!("{}", maximum_triplet_value(vec![1, 2, 3, 4, 5])); // 0
}
