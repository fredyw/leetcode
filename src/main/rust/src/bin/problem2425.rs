// https://leetcode.com/problems/bitwise-xor-of-all-pairings/
pub fn xor_all_nums(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
    let len1 = nums1.len();
    let len2 = nums2.len();
    let xor1 = nums1.into_iter().reduce(|a, b| a ^ b).unwrap();
    let xor2 = nums2.into_iter().reduce(|a, b| a ^ b).unwrap();
    if len1 % 2 == 0 && len2 % 2 == 0 {
        return 0;
    }
    if len1 % 2 != 0 {
        return xor2;
    }
    if len2 % 2 != 0 {
        return xor1;
    }
    xor1 ^ xor2
}

fn main() {
    println!("{}", xor_all_nums(vec![2, 1, 3], vec![10, 2, 5, 0])); // 13
    println!("{}", xor_all_nums(vec![1, 2], vec![3, 4])); // 0
    println!(
        "{}",
        xor_all_nums(vec![8, 6, 29, 2, 26, 16, 15, 29], vec![24, 12, 12])
    ); // 9
    println!("{}", xor_all_nums(vec![8, 6, 2, 26, 16, 15], vec![24])); // 9
}
