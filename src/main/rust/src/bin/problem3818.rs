// https://leetcode.com/problems/minimum-prefix-removal-to-make-array-strictly-increasing/description/
pub fn minimum_prefix_length(nums: Vec<i32>) -> i32 {
    let mut i = nums.len() - 1;
    while i > 0 {
        if nums[i - 1] >= nums[i] {
            break;
        }
        i -= 1;
    }
    i as i32
}

fn main() {
    println!("{}", minimum_prefix_length(vec![1, -1, 2, 3, 3, 4, 5])); // 4
    println!("{}", minimum_prefix_length(vec![4, 3, -2, -5])); // 3
    println!("{}", minimum_prefix_length(vec![1, 2, 3, 4])); // 0
}
