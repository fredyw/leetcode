// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
pub fn count_pairs(nums: Vec<i32>, target: i32) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() {
        for j in i + 1..nums.len() {
            if nums[i] + nums[j] < target {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", count_pairs(vec![-1, 1, 2, 3, 1], 2)); // 3
    println!("{}", count_pairs(vec![-6, 2, 5, -2, -7, -1, 3], -2)); // 10
}
