use std::collections::HashSet;

// https://leetcode.com/problems/check-if-an-array-is-consecutive/description/
pub fn is_consecutive(nums: Vec<i32>) -> bool {
    let n = nums.len();
    let min = nums.iter().min().unwrap();
    let mut set: HashSet<i32> = HashSet::new();
    for num in nums.iter() {
        if set.contains(&num) {
            return false;
        }
        set.insert(*num);
    }
    for i in *min..*min + (n as i32) {
        if !set.contains(&i) {
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
