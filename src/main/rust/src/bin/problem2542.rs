// https://leetcode.com/problems/maximum-subsequence-score/
pub fn max_score(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> i64 {
    let mut nums: Vec<(i32, i32)> = nums1.into_iter().zip(nums2).collect();
    nums.sort_by(|a, b| b.1.cmp(&a.1));
    println!("{:?}", nums);
    let mut sum = 0_i64;
    let mut min = i64::MAX;
    let mut count = 0;
    for (n1, n2) in nums.iter() {
        if count == k {
            break;
        }
        sum += *n1 as i64;
        min = min.min(*n2 as i64);
        count += 1;
    }
    sum * min
}

fn main() {
    println!("{}", max_score(vec![1, 3, 3, 2], vec![2, 1, 3, 4], 3)); // 12
    println!(
        "{}",
        max_score(vec![4, 2, 3, 1, 1], vec![7, 5, 10, 9, 6], 1)
    ); // 30
    println!(
        "{}",
        max_score(vec![4, 2, 1, 3, 1], vec![7, 5, 10, 4, 6], 1)
    ); // 28
    println!("{}", max_score(vec![1, 3, 3, 2], vec![2, 1, 3, 4], 2)); // 15
}
