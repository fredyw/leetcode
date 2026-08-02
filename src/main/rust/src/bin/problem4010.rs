// https://leetcode.com/problems/maximize-pair-strength-using-gcd/description/
pub fn max_pair_strength(nums: Vec<i32>) -> i64 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 { a } else { gcd(b, a % b) }
    }

    let mut answer = 0;
    for i in 0..nums.len() {
        for j in i + 1..nums.len() {
            let strength =
                (nums[i] as i64 * nums[j] as i64) / (gcd(nums[i], nums[j]) as i64).pow(2);
            answer = answer.max(strength);
        }
    }
    answer
}

fn main() {
    println!("{}", max_pair_strength(vec![2, 3, 5])); // 15
    println!("{}", max_pair_strength(vec![4, 6, 8])); // 12
    println!("{}", max_pair_strength(vec![3, 3])); // 1
    println!("{}", max_pair_strength(vec![7, 18, 12])); // 126
}
