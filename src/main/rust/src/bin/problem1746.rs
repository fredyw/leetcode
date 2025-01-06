// https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/
pub fn max_sum_after_operation(nums: Vec<i32>) -> i32 {
    fn f(nums: &Vec<i32>, i: usize, square: bool) -> i32 {
        if i == nums.len() {
            return 0;
        }
        if square {
            f(nums, i + 1, false) + nums[i]
        } else {
            let squared = 0;
            let non_squared = f(nums, i + 1, false) + nums[i];
            squared.max(non_squared)
        }
    }

    f(&nums, 0, false)
}

fn main() {
    println!("{}", max_sum_after_operation(vec![2, -1, -4, -3])); // 17
    println!("{}", max_sum_after_operation(vec![1, -1, 1, 1, -1, -1, 1])); // 4
}
