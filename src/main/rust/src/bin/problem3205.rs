// https://leetcode.com/problems/maximum-array-hopping-score-i/description/
pub fn max_score(nums: Vec<i32>) -> i32 {
    fn max_score(nums: &Vec<i32>, i: usize, j: usize, memo: &mut Vec<Vec<i32>>) -> i32 {
        if j == nums.len() {
            return 0;
        }
        if memo[i][j] != -1 {
            return memo[i][j];
        }
        let score = (j as i32 - i as i32) * nums[j];
        let hop = max_score(nums, j, j + 1, memo) + score;
        let skip = max_score(nums, i, j + 1, memo);
        let max = hop.max(skip);
        memo[i][j] = max;
        max
    }

    max_score(&nums, 0, 0, &mut vec![vec![-1; nums.len()]; nums.len()])
}

fn main() {
    println!("{}", max_score(vec![1, 5, 8])); // 16
    println!("{}", max_score(vec![4, 5, 2, 8, 9, 1, 3])); // 42
    println!("{}", max_score(vec![1, 2])); // 2
}
