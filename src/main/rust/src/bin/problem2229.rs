// https://leetcode.com/problems/check-if-an-array-is-consecutive/description/
pub fn is_consecutive(mut nums: Vec<i32>) -> bool {
    nums.sort();
    for i in 0..nums.len() - 1 {
        if nums[i] + 1 != nums[i + 1] {
            return false;
        }
    }
    true
}

fn main() {
    println!("{}", is_consecutive(vec![1, 3, 4, 2])); // true
    println!("{}", is_consecutive(vec![1, 3])); // false
    println!("{}", is_consecutive(vec![3, 5, 4])); // true
}
