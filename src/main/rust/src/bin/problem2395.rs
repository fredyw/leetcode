use std::collections::HashSet;

// https://leetcode.com/problems/find-subarrays-with-equal-sum/
pub fn find_subarrays(nums: Vec<i32>) -> bool {
    let mut set: HashSet<i32> = HashSet::new();
    let mut i = 0;
    while i < nums.len() - 1 {
        let sum = nums[i] + nums[i + 1];
        if set.contains(&sum) {
            return true;
        }
        set.insert(sum);
        i += 1;
    }
    false
}

fn main() {
    println!("{}", find_subarrays(vec![4, 2, 4])); // true
    println!("{}", find_subarrays(vec![1, 2, 3, 4, 5])); // false
    println!("{}", find_subarrays(vec![0, 0, 0])); // true
}
