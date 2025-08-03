// https://leetcode.com/problems/trionic-array-i/description/
pub fn is_trionic(nums: Vec<i32>) -> bool {
    let mut group = 1;
    let mut count = 0;
    let mut increase = true;
    for i in 0..nums.len() - 1 {
        if nums[i] == nums[i + 1] {
            return false;
        }
        if increase && nums[i] > nums[i + 1] && count == 0 {
            return false;
        }
        if !increase && nums[i] < nums[i + 1] && count == 0 {
            return false;
        }
        if increase && nums[i] < nums[i + 1] {
            count += 1;
        } else if increase && nums[i] > nums[i + 1] {
            increase = !increase;
            count = 0;
            group += 1;
        } else if !increase && nums[i] > nums[i + 1] {
            count += 1;
        } else if !increase && nums[i] < nums[i + 1] {
            increase = !increase;
            count = 0;
            group += 1;
        }
    }
    group == 3
}

fn main() {
    // println!("{}", is_trionic(vec![1, 3, 5, 4, 2, 6])); // true
    // println!("{}", is_trionic(vec![2, 1, 3])); // false
    // println!("{}", is_trionic(vec![1, 3, 5, 4, 2, 6, 4])); // false
    // println!("{}", is_trionic(vec![9, 1, 7])); // false
    println!("{}", is_trionic(vec![5, 9, 1, 7])); // false
}
