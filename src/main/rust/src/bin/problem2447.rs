// https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k/
pub fn subarray_gcd(nums: Vec<i32>, k: i32) -> i32 {
    fn gcd(nums: &[i32]) -> i32 {
        fn f(a: i32, b: i32) -> i32 {
            if b == 0 {
                a
            } else {
                f(b, a % b)
            }
        }

        let mut result = nums[0];
        for i in 1..nums.len() {
            result = f(result, nums[i]);
        }
        result
    }

    let mut answer = 0;
    for i in 0..nums.len() {
        for j in i + 1..=nums.len() {
            if gcd(&nums[i..j]) == k {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", subarray_gcd(vec![9, 3, 1, 2, 6, 3], 3)); // 4
    println!("{}", subarray_gcd(vec![4], 7)); // 0
    println!("{}", subarray_gcd(vec![9, 6, 3], 3)); // 4
    println!("{}", subarray_gcd(vec![2, 4, 6, 8, 16], 3)); // 4
    println!("{}", subarray_gcd(vec![2], 4)); // 0
    println!("{}", subarray_gcd(vec![6], 2)); // 0
    println!("{}", subarray_gcd(vec![9, 6], 3)); // 1
    println!("{}", subarray_gcd(vec![9, 3], 3)); // 2
}
