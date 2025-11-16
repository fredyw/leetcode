// https://leetcode.com/problems/maximum-array-hopping-score-ii
pub fn max_score(nums: Vec<i32>) -> i64 {
    fn max_score(nums: &Vec<i32>, i: usize, memo: &mut Vec<i64>) -> i64 {
        if memo[i] != -1 {
            return memo[i];
        }
        let mut max = 0;
        for j in i + 1..nums.len() {
            let score = max_score(nums, j, memo) + ((j as i64 - i as i64) * nums[j] as i64);
            max = max.max(score);
        }
        memo[i] = max;
        max
    }

    max_score(&nums, 0, &mut vec![-1; nums.len()])
}

fn main() {
    println!("{}", max_score(vec![1, 5, 8])); // 16
    println!("{}", max_score(vec![4, 5, 2, 8, 9, 1, 3])); // 42
}
