// https://leetcode.com/problems/find-the-number-of-good-pairs-i/description/
pub fn number_of_pairs(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> i32 {
    let mut answer = 0;
    for i in 0..nums1.len() {
        for j in 0..nums2.len() {
            if nums1[i] % (nums2[j] * k) == 0 {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", number_of_pairs(vec![1, 3, 4], vec![1, 3, 4], 1)); // 5
    println!("{}", number_of_pairs(vec![1, 2, 4, 12], vec![2, 4], 3)); // 2
}
