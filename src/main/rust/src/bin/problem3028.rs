// https://leetcode.com/problems/ant-on-the-boundary/
pub fn return_to_boundary_count(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut sum = 0;
    for num in nums.iter() {
        sum += num;
        if sum == 0 {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", return_to_boundary_count(vec![2, 3, -5])); // 1
    println!("{}", return_to_boundary_count(vec![3, 2, -3, -4])); // 0
    println!("{}", return_to_boundary_count(vec![2, 3, -5, 5, -5])); // 2
}
