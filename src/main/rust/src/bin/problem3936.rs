// https://leetcode.com/problems/minimum-swaps-to-move-zeros-to-end/description/
pub fn minimum_swaps(nums: Vec<i32>) -> i32 {
    let total_zero_count = nums.iter().filter(|&n| *n == 0).count();
    let mut zero_count = 0;
    for i in nums.len() - total_zero_count..nums.len() {
        if nums[i] == 0 {
            zero_count += 1;
        }
    }
    (total_zero_count - zero_count) as i32
}

fn main() {
    println!("{}", minimum_swaps(vec![0, 1, 0, 3, 12])); // 2
    println!("{}", minimum_swaps(vec![0, 1, 0, 2])); // 1
    println!("{}", minimum_swaps(vec![1, 2, 0])); // 0
}
