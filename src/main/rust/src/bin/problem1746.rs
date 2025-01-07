// https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/
pub fn max_sum_after_operation(nums: Vec<i32>) -> i32 {
    fn max_sum_after_operation(
        nums: &Vec<i32>,
        i: usize,
        can_square: bool,
        memo: &mut Vec<Vec<i32>>,
        answer: &mut i32,
    ) -> i32 {
        if i == nums.len() {
            return 0;
        }
        if memo[i][if can_square { 1 } else { 0 }] != -1 {
            return memo[i][if can_square { 1 } else { 0 }];
        }
        let mut max = if can_square {
            let squared = (nums[i] * nums[i]).max(
                max_sum_after_operation(nums, i + 1, false, memo, answer) + (nums[i] * nums[i]),
            );
            let non_squared =
                nums[i].max(max_sum_after_operation(nums, i + 1, true, memo, answer) + nums[i]);
            squared.max(non_squared)
        } else {
            nums[i].max(max_sum_after_operation(nums, i + 1, false, memo, answer) + nums[i])
        };
        memo[i][if can_square { 1 } else { 0 }] = max;
        *answer = *answer.max(&mut max);
        max
    }

    let mut answer = 0;
    max_sum_after_operation(
        &nums,
        0,
        true,
        &mut vec![vec![-1; 2]; nums.len()],
        &mut answer,
    );
    answer
}

fn main() {
    println!("{}", max_sum_after_operation(vec![2, -1, -4, -3])); // 17
    println!("{}", max_sum_after_operation(vec![1, -1, 1, 1, -1, -1, 1])); // 4
}
