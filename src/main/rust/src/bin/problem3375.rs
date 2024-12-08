use std::collections::HashSet;

// https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/
pub fn min_operations(nums: Vec<i32>, k: i32) -> i32 {
    let mut set: HashSet<i32> = HashSet::new();
    for num in nums {
        if num < k {
            return -1;
        } else if num > k {
            set.insert(num);
        }
    }
    set.len() as i32
}

fn main() {
    println!("{}", min_operations(vec![5, 2, 5, 4, 5], 2)); // 2
    println!("{}", min_operations(vec![2, 1, 2], 2)); // -1
    println!("{}", min_operations(vec![9, 7, 5, 3], 1)); // 4
}
