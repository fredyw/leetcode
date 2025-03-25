// https://leetcode.com/problems/maximize-score-after-pair-deletions/
pub fn max_score(nums: Vec<i32>) -> i32 {
    fn max_score(nums: &Vec<i32>, i: usize, j: usize, memo: &mut Vec<Vec<i32>>) -> i32 {
        if j - i + 1 <= 2 {
            return 0;
        }
        if memo[i][j] != -1 {
            return memo[i][j];
        }
        let a = max_score(nums, i + 2, j, memo) + nums[i] + nums[i + 1];
        let b = max_score(nums, i, j - 2, memo) + nums[j] + nums[j - 1];
        let c = max_score(nums, i + 1, j - 1, memo) + nums[i] + nums[j];
        let max = a.max(b.max(c));
        memo[i][j] = max;
        max
    }

    max_score(
        &nums,
        0,
        nums.len() - 1,
        &mut vec![vec![-1; nums.len()]; nums.len()],
    )
}

fn main() {
    println!("{}", max_score(vec![2, 4, 1])); // 6
    println!("{}", max_score(vec![5, -1, 4, 2])); // 7
    println!(
        "{}",
        max_score(vec![8059, -2702, -8432, 846, -1793, -8320, 6115, 1853])
    ); // 6760
}
