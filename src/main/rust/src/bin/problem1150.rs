// https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
pub fn is_majority_element(nums: Vec<i32>, target: i32) -> bool {
    let mut count = 0;
    let mut i = nums.partition_point(|&n| n < target);
    while i < nums.len() && nums[i] == target {
        i += 1;
        count += 1;
    }
    count > (nums.len() / 2)
}

fn main() {
    println!(
        "{}",
        is_majority_element(vec![2, 4, 5, 5, 5, 5, 5, 6, 6], 5)
    ); // true
    println!("{}", is_majority_element(vec![10, 100, 101, 101], 101)); // true
}
