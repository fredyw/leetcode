// https://leetcode.com/problems/maximum-number-of-matching-indices-after-right-shifts/description/
pub fn maximum_matching_indices(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 0..nums1.len() {
        let mut count = 0;
        for j in 0..nums1.len() {
            if nums1[(i + j) % nums1.len()] == nums2[j] {
                count += 1;
            }
        }
        answer = answer.max(count);
    }
    answer
}

fn main() {
    println!(
        "{}",
        maximum_matching_indices(vec![3, 1, 2, 3, 1, 2], vec![1, 2, 3, 1, 2, 3])
    ); // 6
    println!(
        "{}",
        maximum_matching_indices(vec![1, 4, 2, 5, 3, 1], vec![2, 3, 1, 2, 4, 6])
    ); // 3
}
