// https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/
pub fn longest_alternating_subarray(nums: Vec<i32>, threshold: i32) -> i32 {
    fn is_odd(n: i32, threshold: i32) -> bool {
        n % 2 != 0 && n <= threshold
    }

    fn is_even(n: i32, threshold: i32) -> bool {
        n % 2 == 0 && n <= threshold
    }

    let mut answer = 0;
    let mut i = 0;
    let mut length: i32;
    while i < nums.len() {
        if i + 1 < nums.len() && is_even(nums[i], threshold) && is_odd(nums[i + 1], threshold) {
            length = 2;
            let mut odd = true;
            i += 1;
            while i < nums.len() - 1 {
                if odd && is_odd(nums[i], threshold) && is_even(nums[i + 1], threshold) {
                    length += 1;
                } else if !odd && is_even(nums[i], threshold) && is_odd(nums[i + 1], threshold) {
                    length += 1;
                } else {
                    break;
                }
                odd = !odd;
                i += 1;
            }
        } else if is_even(nums[i], threshold) {
            length = 1;
        } else {
            length = 0;
        }
        answer = answer.max(length);
        i += 1;
    }
    answer
}

fn main() {
    println!("{}", longest_alternating_subarray(vec![3, 2, 5, 4], 5)); // 3
    println!("{}", longest_alternating_subarray(vec![1, 2], 2)); // 1
    println!("{}", longest_alternating_subarray(vec![2, 3, 4, 5], 4)); // 3
    println!("{}", longest_alternating_subarray(vec![3, 2, 4, 5], 4)); // 1
    println!("{}", longest_alternating_subarray(vec![3, 2, 1, 5], 4)); // 2
    println!("{}", longest_alternating_subarray(vec![5, 5, 5, 5], 4)); // 0
    println!("{}", longest_alternating_subarray(vec![1, 1, 1, 1], 1)); // 0
}
