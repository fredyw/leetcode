// https://leetcode.com/problems/maximum-subarray-with-equal-products/description/
pub fn max_length(nums: Vec<i32>) -> i32 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            gcd(b, a % b)
        }
    }

    fn lcm(a: i32, b: i32) -> i32 {
        (a * b) / gcd(a, b)
    }

    todo!()
}

fn main() {
    println!("{}", max_length(vec![1, 2, 1, 2, 1, 1, 1])); // 5
    println!("{}", max_length(vec![2, 3, 4, 5, 6])); // 3
    println!("{}", max_length(vec![1, 2, 3, 1, 4, 5, 1])); // 5
}
