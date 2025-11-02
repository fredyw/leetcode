// https://leetcode.com/problems/longest-fibonacci-subarray/description/
pub fn longest_subarray(nums: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", longest_subarray(vec![1, 1, 1, 1, 2, 3, 5, 1])); // 5
    println!("{}", longest_subarray(vec![5, 2, 7, 9, 16])); // 5
    println!(
        "{}",
        longest_subarray(vec![1000000000, 1000000000, 1000000000])
    ); // 2
}
