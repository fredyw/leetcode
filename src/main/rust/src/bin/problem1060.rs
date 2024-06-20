// https://leetcode.com/problems/missing-element-in-sorted-array/description/
pub fn missing_element(nums: Vec<i32>, mut k: i32) -> i32 {
    let mut i = 0;
    while i < nums.len() - 1 {
        let diff = nums[i + 1] - nums[i];
        if diff > 1 {
            if k - (diff - 1) <= 0 {
                return nums[i] + k;
            }
            k -= diff - 1;
        }
        i += 1;
    }
    return nums[nums.len() - 1] + k;
}

fn main() {
    println!("{}", missing_element(vec![4, 7, 9, 10], 1)); // 5
    println!("{}", missing_element(vec![4, 7, 9, 10], 3)); // 8
    println!("{}", missing_element(vec![4, 7, 10], 3)); // 8
    println!("{}", missing_element(vec![1, 2, 4], 3)); // 6
    println!("{}", missing_element(vec![1, 2, 3], 3)); // 6
    println!("{}", missing_element(vec![4, 19, 25], 5)); // 9
    println!("{}", missing_element(vec![6, 7, 10, 11, 19, 21, 23], 2)); // 9
}
