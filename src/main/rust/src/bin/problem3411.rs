// https://leetcode.com/problems/maximum-subarray-with-equal-products/description/
pub fn max_length(nums: Vec<i32>) -> i32 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            gcd(b, a % b)
        }
    }

    fn gcd_arr(nums: &[i32]) -> i32 {
        let mut result = nums[0];
        for &num in &nums[1..] {
            result = gcd(result, num);
        }
        result
    }

    fn lcm(a: i32, b: i32) -> i32 {
        (a * b) / gcd(a, b)
    }

    fn lcm_arr(nums: &[i32]) -> i32 {
        let mut result = nums[0];
        for &num in &nums[1..] {
            result = lcm(result, num);
        }
        result
    }

    fn prod_arr(nums: &[i32]) -> i32 {
        nums.iter().product()
    }

    let mut answer = 0;
    for i in 0..nums.len() {
        for j in i + 1..=nums.len() {
            let s = &nums[i..j];
            if prod_arr(s) == gcd_arr(s) * lcm_arr(s) {
                answer = answer.max(j as i32 - i as i32);
            }
        }
    }
    answer
}

fn main() {
    println!("{}", max_length(vec![1, 2, 1, 2, 1, 1, 1])); // 5
    println!("{}", max_length(vec![2, 3, 4, 5, 6])); // 3
    println!("{}", max_length(vec![1, 2, 3, 1, 4, 5, 1])); // 5
}
