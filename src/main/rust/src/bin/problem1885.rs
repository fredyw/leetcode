// https://leetcode.com/problems/count-pairs-in-two-arrays/description/
pub fn count_pairs(nums1: Vec<i32>, nums2: Vec<i32>) -> i64 {
    let mut answer = 0;
    for i in 0..nums1.len() {
        for j in i + 1..nums1.len() {
            if nums1[i] + nums1[j] > nums2[i] + nums2[j] {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", count_pairs(vec![2, 1, 2, 1], vec![1, 2, 1, 2])); // 1
    println!("{}", count_pairs(vec![1, 10, 6, 2], vec![1, 4, 1, 5])); // 5
}
