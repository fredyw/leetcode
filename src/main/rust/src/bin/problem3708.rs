// https://leetcode.com/problems/longest-fibonacci-subarray/description/
pub fn longest_subarray(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut length = 2;
    for i in 0..nums.len() - 2 {
        if nums[i] + nums[i + 1] == nums[i + 2] {
            length += 1;
        } else {
            length = 2;
        }
        answer = answer.max(length);
    }
    answer
}

fn main() {
    println!("{}", longest_subarray(vec![1, 1, 1, 1, 2, 3, 5, 1])); // 5
    println!("{}", longest_subarray(vec![5, 2, 7, 9, 16])); // 5
    println!(
        "{}",
        longest_subarray(vec![1000000000, 1000000000, 1000000000])
    ); // 2
}
