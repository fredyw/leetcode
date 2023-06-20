// https://leetcode.com/problems/find-the-value-of-the-partition/
pub fn find_value_of_partition(mut nums: Vec<i32>) -> i32 {
    let mut answer = i32::MAX;
    nums.sort();
    let mut i = 0;
    while i < nums.len() - 1 {
        answer = answer.min((nums[i] - nums[i + 1]).abs());
        i += 1;
    }
    answer
}

fn main() {
    println!("{}", find_value_of_partition(vec![1, 3, 2, 4])); // 1
    println!("{}", find_value_of_partition(vec![100, 1, 10])); // 9
}
