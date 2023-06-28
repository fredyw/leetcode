// https://leetcode.com/problems/maximum-subsequence-score/
pub fn max_score(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> i64 {
    let mut nums: Vec<(i32, i32)> = nums1.into_iter().zip(nums2).collect();
    nums.sort_by(|a, b| b.1.cmp(&a.1));
    println!("{:?}", nums);
    let mut answer = 0;
    let mut sum = 0_i64;
    let mut count = 0;
    for (i, (n1, n2)) in nums.iter().enumerate() {
        if count >= k {
            sum -= nums[i - k as usize].0 as i64;
        }
        sum += *n1 as i64;
        if count >= k - 1 {
            println!("sum: {}, min: {}", sum, n2);
            answer = answer.max(sum * *n2 as i64);
        }
        count += 1;
    }
    answer
}

fn main() {
    // println!("{}", max_score(vec![1, 3, 3, 2], vec![2, 1, 3, 4], 3)); // 12
    // println!(
    //     "{}",
    //     max_score(vec![4, 2, 3, 1, 1], vec![7, 5, 10, 9, 6], 1)
    // ); // 30
    // println!(
    //     "{}",
    //     max_score(vec![4, 2, 1, 3, 1], vec![7, 5, 10, 4, 6], 1)
    // ); // 28
    // println!("{}", max_score(vec![1, 3, 3, 2], vec![2, 1, 3, 4], 2)); // 15
    println!("{}", max_score(vec![2, 1, 14, 12], vec![11, 7, 13, 6], 3)); // 168
}
