// https://leetcode.com/problems/special-array-i/description/
pub fn is_array_special(nums: Vec<i32>) -> bool {
    for i in 0..nums.len() - 1 {
        if nums[i] % 2 == 0 && nums[i + 1] % 2 == 0 || nums[i] % 2 != 0 && nums[i + 1] % 2 != 0 {
            return false;
        }
    }
    true
}

fn main() {
    println!("{}", is_array_special(vec![1])); // true
    println!("{}", is_array_special(vec![2, 1, 4])); // true
    println!("{}", is_array_special(vec![4, 3, 1, 6])); // false
}
