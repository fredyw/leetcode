// https://leetcode.com/problems/maximum-subsequence-score/
pub fn max_score(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> i64 {
    let mut v: Vec<(usize, i32)> = nums1.iter().map(|n| *n).enumerate().collect();
    v.sort_by(|a, b| nums2[b.0].cmp(&nums2[a.0]));
    println!("{:?}", v);
    let mut sum: i64 = 0;
    let mut min = i64::MAX;
    let mut count = 0;
    for (i, n) in v.iter() {
        if count == k {
            break;
        }
        sum += *n as i64;
        min = min.min(nums2[*i] as i64);
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
