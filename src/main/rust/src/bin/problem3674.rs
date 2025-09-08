// https://leetcode.com/problems/minimum-operations-to-equalize-array/description/
pub fn min_operations(nums: Vec<i32>) -> i32 {
    let bitwise_and = nums.iter().copied().reduce(|acc, num| acc & num).unwrap();
    let mut answer = 0;
    let mut i = 0;
    while i < nums.len() {
        if nums[i] != bitwise_and {
            answer += 1;
            while i < nums.len() && nums[i] != bitwise_and {
                i += 1;
            }
        } else {
            i += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", min_operations(vec![1, 2])); // 1
    println!("{}", min_operations(vec![5, 5, 5])); // 0
    println!("{}", min_operations(vec![8, 1, 10])); // 1
    println!("{}", min_operations(vec![37, 4, 125])); // 1
}
