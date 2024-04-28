// https://leetcode.com/problems/find-the-integer-added-to-array-i/description/
pub fn added_integer(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
    let min1 = nums1.iter().min().unwrap();
    let min2 = nums2.iter().min().unwrap();
    min2 - min1
}

fn main() {
    println!("{}", added_integer(vec![2, 6, 4], vec![9, 7, 5])); // 3
    println!("{}", added_integer(vec![10], vec![5])); // -5
    println!("{}", added_integer(vec![1, 1, 1, 1], vec![1, 1, 1, 1])); // 0
}
