// https://leetcode.com/problems/maximum-median-sum-of-subsequences-of-size-3/description/
pub fn maximum_median_sum(mut nums: Vec<i32>) -> i64 {
    nums.sort();
    let mut answer = 0;
    let mut i = nums.len() as isize - 2;
    let mut count = 0;
    while count < nums.len() / 3 {
        answer += nums[i as usize] as i64;
        i -= 2;
        count += 1;
    }
    answer
}

fn main() {
    println!("{}", maximum_median_sum(vec![2, 1, 3, 2, 1, 3])); // 5
    println!("{}", maximum_median_sum(vec![1, 1, 10, 10, 10, 10])); // 20
}
