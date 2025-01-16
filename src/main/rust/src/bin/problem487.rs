// https://leetcode.com/problems/max-consecutive-ones-ii/description/
pub fn find_max_consecutive_ones(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut prev = 0;
    let mut current = 0;
    let mut zero_count = 0;
    while current < nums.len() {
        if nums[current] == 0 {
            if zero_count == 1 {
                zero_count -= 1;
                prev = current;
            }
            zero_count += 1;
        }
        answer = answer.max(current as i32 - prev as i32 + 1);
        current += 1;
    }
    answer
}

fn main() {
    println!("{}", find_max_consecutive_ones(vec![1, 0, 1, 1, 0])); // 4
    println!("{}", find_max_consecutive_ones(vec![1, 0, 1, 1, 0, 1])); // 4
    println!("{}", find_max_consecutive_ones(vec![1, 1, 1])); // 3
    println!("{}", find_max_consecutive_ones(vec![0, 1, 1, 0])); // 3
    println!("{}", find_max_consecutive_ones(vec![0, 0, 0])); // 1
}
