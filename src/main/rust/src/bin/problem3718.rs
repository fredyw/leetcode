use std::collections::HashSet;

// https://leetcode.com/problems/smallest-missing-multiple-of-k/description/
pub fn missing_multiple(nums: Vec<i32>, k: i32) -> i32 {
    let nums: HashSet<i32> = nums.into_iter().collect();
    let mut n = k;
    loop {
        if !nums.contains(&n) {
            return n;
        }
        n += k;
    }
}

fn main() {
    println!("{}", missing_multiple(vec![8, 2, 3, 4, 6], 2)); // 10
    println!("{}", missing_multiple(vec![1, 4, 7, 10, 15], 5)); // 5
}
