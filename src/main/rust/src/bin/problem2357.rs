use std::collections::HashSet;

// https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
pub fn minimum_operations(nums: Vec<i32>) -> i32 {
    let mut set: HashSet<i32> = HashSet::new();
    for num in nums.iter() {
        if *num != 0 {
            set.insert(*num);
        }
    }
    set.len() as i32
}

fn main() {
    println!("{}", minimum_operations(vec![1, 5, 0, 3, 5])); // 3
    println!("{}", minimum_operations(vec![0])); //
    println!("{}", minimum_operations(vec![1, 5, 0, 3, 5, 2])); // 4
}
