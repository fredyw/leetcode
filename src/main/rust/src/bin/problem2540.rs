use std::collections::HashSet;

// https://leetcode.com/problems/minimum-common-value/
pub fn get_common(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
    let set: HashSet<i32> = nums1.into_iter().collect();
    for n in nums2.into_iter() {
        if set.contains(&n) {
            return n;
        }
    }
    -1
}

fn main() {
    println!("{}", get_common(vec![1, 2, 3], vec![2, 4])); // 2
    println!("{}", get_common(vec![1, 2, 3, 6], vec![2, 3, 4, 5])); // 2
}
