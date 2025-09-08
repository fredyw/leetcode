// https://leetcode.com/problems/minimum-operations-to-equalize-array/description/
pub fn min_operations(nums: Vec<i32>) -> i32 {
    for i in 0..nums.len() - 1 {
        if nums[i] != nums[i + 1] {
            return 1;
        }
    }
    0
}

fn main() {
    println!("{}", min_operations(vec![1, 2])); // 1
    println!("{}", min_operations(vec![5, 5, 5])); // 0
    println!("{}", min_operations(vec![8, 1, 10])); // 1
    println!("{}", min_operations(vec![37, 4, 125])); // 1
}
