// https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/
pub fn longest_subarray(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let max = nums.iter().max().unwrap();
    let mut count = 0;
    for num in nums.iter() {
        if num == max {
            count += 1;
        } else {
            count = 0;
        }
        answer = answer.max(count);
    }
    answer
}

fn main() {
    println!("{}", longest_subarray(vec![1, 2, 3, 3, 2, 2])); // 2
    println!("{}", longest_subarray(vec![1, 2, 3, 4])); // 1
    println!(
        "{}",
        longest_subarray(vec![
            311155, 311155, 311155, 311155, 311155, 311155, 311155, 311155, 201191, 311155
        ])
    ); // 8
    println!(
        "{}",
        longest_subarray(vec![
            96317, 96317, 96317, 96317, 96317, 96317, 96317, 96317, 96317, 279979
        ])
    ); // 1
}
