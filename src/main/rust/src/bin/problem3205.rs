// https://leetcode.com/problems/maximum-array-hopping-score-i/description/
pub fn max_score(nums: Vec<i32>) -> i32 {
    fn max_score(nums: &Vec<i32>, i: usize, j: usize) -> i32 {
        if j == nums.len() {
            return 0;
        }
        let hop = max_score(nums, j, j + 1) + (j as i32 - i as i32) * nums[j];
        let skip = max_score(nums, i, j + 1) + (j as i32 - i as i32) * nums[j];
        let max = hop.max(skip);
        max
    }

    max_score(&nums, 0, 0)
}

fn main() {
    println!("{}", max_score(vec![1, 5, 8])); // 16
    println!("{}", max_score(vec![4, 5, 2, 8, 9, 1, 3])); // 42
    println!("{}", max_score(vec![1, 2])); // 2
}
