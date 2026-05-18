// https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/description/
pub fn gcd_sum(nums: Vec<i32>) -> i64 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 { a } else { gcd(b, a % b) }
    }

    let mut max = 0;
    let mut prefix_gcd = vec![0; nums.len()];
    for (i, n) in nums.iter().enumerate() {
        max = max.max(*n);
        prefix_gcd[i] = gcd(nums[i], max);
    }
    prefix_gcd.sort_unstable();
    let mut answer = 0;
    for i in 0..prefix_gcd.len() / 2 {
        answer += gcd(prefix_gcd[i], prefix_gcd[prefix_gcd.len() - 1 - i]) as i64;
    }
    answer
}

fn main() {
    println!("{}", gcd_sum(vec![2, 6, 4])); // 2
    println!("{}", gcd_sum(vec![3, 6, 2, 8])); // 5
}
