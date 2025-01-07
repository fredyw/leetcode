// https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/
pub fn max_sum_after_operation(nums: Vec<i32>) -> i32 {
    fn f(nums: &Vec<i32>, i: usize, can_square: bool, answer: &mut i32) -> i32 {
        if i == nums.len() {
            return 0;
        }
        let mut max = if can_square {
            let squared = f(nums, i + 1, false, answer) + (nums[i] * nums[i]);
            let non_squared = nums[i].max(f(nums, i + 1, true, answer) + nums[i]);
            squared.max(non_squared)
        } else {
            nums[i].max(f(nums, i + 1, false, answer) + nums[i])
        };
        println!("max: {}", max);
        *answer = *answer.max(&mut max);
        max
    }

    let mut answer = 0;
    f(&nums, 0, true, &mut answer);
    answer
}

fn main() {
    println!("{}", max_sum_after_operation(vec![2, -1, -4, -3])); // 17
                                                                  // println!("{}", max_sum_after_operation(vec![1, -1, 1, 1, -1, -1, 1])); // 4
}
