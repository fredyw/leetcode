// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/description/
pub fn largest_perimeter(mut nums: Vec<i32>) -> i64 {
    nums.sort();
    let mut answer = -1;
    let mut sum = nums[0] as i64 + nums[1] as i64;
    for i in 2..nums.len() {
        if sum > nums[i] as i64 {
            sum += nums[i] as i64;
            answer = answer.max(sum);
        } else {
            sum += nums[i] as i64;
        }
    }
    answer
}

fn main() {
    println!("{}", largest_perimeter(vec![5, 5, 5])); // 15
    println!("{}", largest_perimeter(vec![1, 12, 1, 2, 5, 50, 3])); // 12
    println!("{}", largest_perimeter(vec![5, 5, 50])); // -1
    println!("{}", largest_perimeter(vec![1, 1, 2, 3, 5, 12, 40, 50])); // 114
}
