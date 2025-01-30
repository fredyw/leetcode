// https://leetcode.com/problems/maximum-sum-score-of-array/description/
pub fn maximum_sum_score(nums: Vec<i32>) -> i64 {
    let mut prefix_sums: Vec<i64> = vec![0; nums.len()];
    let mut suffix_sums: Vec<i64> = vec![0; nums.len()];
    let mut i = 0;
    let mut j: isize = nums.len() as isize - 1;
    while i < nums.len() {
        prefix_sums[i] += if i == 0 { 0 } else { prefix_sums[i - 1] } + nums[i] as i64;
        suffix_sums[j as usize] += if j == nums.len() as isize - 1 {
            0
        } else {
            suffix_sums[j as usize + 1]
        } + nums[j as usize] as i64;
        i += 1;
        j -= 1;
    }
    let mut answer = 0;
    for i in 0..nums.len() {
        let max = prefix_sums[i].max(suffix_sums[i]);
        answer = if i == 0 { max } else { answer.max(max) };
    }
    answer
}

fn main() {
    println!("{}", maximum_sum_score(vec![4, 3, -2, 5])); // 10
    println!("{}", maximum_sum_score(vec![-3, -5])); // -3
}
