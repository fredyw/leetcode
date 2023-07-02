// https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/
pub fn longest_alternating_subarray(nums: Vec<i32>, threshold: i32) -> i32 {
    todo!()
}

fn main() {
    println!("{}", longest_alternating_subarray(vec![3, 2, 5, 4], 5)); // 3
    println!("{}", longest_alternating_subarray(vec![1, 2], 2)); // 1
    println!("{}", longest_alternating_subarray(vec![2, 3, 4, 5], 4)); // 3
    println!("{}", longest_alternating_subarray(vec![3, 2, 4, 5], 4)); // 1
    println!("{}", longest_alternating_subarray(vec![3, 2, 1, 5], 4)); // 2
}
