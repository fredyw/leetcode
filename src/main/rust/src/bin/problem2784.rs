// https://leetcode.com/problems/check-if-array-is-good/
pub fn is_good(mut nums: Vec<i32>) -> bool {
    nums.sort();
    if nums.len() != nums[nums.len() - 1] as usize + 1 {
        return false;
    }
    if nums[0] != 1 {
        return false;
    }
    for i in 0..nums.len() - 2 {
        if nums[i] + 1 != nums[i + 1] {
            return false;
        }
    }
    nums[nums.len() - 2] == nums[nums.len() - 1]
}

fn main() {
    println!("{}", is_good(vec![2, 1, 3])); // false
    println!("{}", is_good(vec![1, 3, 3, 2])); // true
    println!("{}", is_good(vec![1, 1])); // true
    println!("{}", is_good(vec![3, 4, 4, 1, 2, 1])); // false
}
