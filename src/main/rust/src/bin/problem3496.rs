// https://leetcode.com/problems/maximize-score-after-pair-deletions/
pub fn max_score(nums: Vec<i32>) -> i32 {
    fn max_score(nums: &Vec<i32>, i: usize, j: usize) -> i32 {
        if j - i + 1 <= 2 {
            return 0;
        }
        let a = max_score(nums, i + 2, j) + nums[i] + nums[i + 1];
        let b = max_score(nums, i, j - 2) + nums[j] + nums[j - 1];
        let c = max_score(nums, i + 1, j - 1) + nums[i] + nums[j];
        let max = a.max(b.max(c));
        max
    }

    max_score(&nums, 0, nums.len() - 1)
}

fn main() {
    println!("{}", max_score(vec![2, 4, 1])); // 6
    println!("{}", max_score(vec![5, -1, 4, 2])); // 7
}
