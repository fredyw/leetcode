// https://leetcode.com/problems/difference-between-peaks-and-valleys/description/
pub fn peak_valley_difference(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 1..nums.len() - 1 {
        if nums[i] > nums[i - 1] && nums[i] > nums[i + 1] {
            answer += nums[i];
        }
        if nums[i] < nums[i - 1] && nums[i] < nums[i + 1] {
            answer -= nums[i];
        }
    }
    answer
}

fn main() {
    println!("{}", peak_valley_difference(vec![1, 5, 2, 4, 1, 3, 0])); // 9
    println!("{}", peak_valley_difference(vec![-5, -6, -1, -2, 5, 3, 2])); // 12
    println!("{}", peak_valley_difference(vec![6, 5, 2, 5, 5, 3, 6])); // -5
}
