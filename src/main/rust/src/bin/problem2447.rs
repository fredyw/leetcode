// https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k/
pub fn subarray_gcd(nums: Vec<i32>, k: i32) -> i32 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            gcd(b, a % b)
        }
    }

    let mut answer = 0;
    for i in 0..nums.len() {
        let mut result = nums[i];
        if result == k {
            answer += 1;
        }
        for j in i + 1..nums.len() {
            result = gcd(result, nums[j]);
            if result == k {
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
