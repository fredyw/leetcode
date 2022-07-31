// https://leetcode.com/problems/jump-game-vi/
pub fn max_result(nums: Vec<i32>, k: i32) -> i32 {
    fn f(nums: &Vec<i32>, k: i32, index: i32, memo: &mut Vec<i32>) -> i32 {
        if index == nums.len() as i32 - 1 {
            return nums[index as usize];
        }
        if memo[index as usize] != i32::MIN {
            return memo[index as usize];
        }
        let mut max = i32::MIN;
        for i in (index + 1)..=(nums.len() as i32 - 1).min(index + k) {
            let mut x = f(nums, k, i, memo);
            if x != i32::MIN {
                x += nums[index as usize];
            }
            max = max.max(x);
        }
        memo[index as usize] = max;
        max
    }

    f(&nums, k, 0, &mut vec![i32::MIN; nums.len()])
}

fn main() {
    println!("{}", max_result(vec![1, -1, -2, 4, -7, 3], 2)); // 7
    println!("{}", max_result(vec![10, -5, -2, 4, 0, 3], 3)); // 17
    println!("{}", max_result(vec![1, -5, -20, 4, -1, 3, -6, -3], 2)); // 0
    println!("{}", max_result(vec![3, -6, -3], 2)); // 0
}
