// https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/description/
pub fn gcd_sum(nums: Vec<i32>) -> i64 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 { a } else { gcd(b, a % b) }
    }
    todo!()
}

fn main() {
    println!("{}", gcd_sum(vec![2, 6, 4])); // 2
    println!("{}", gcd_sum(vec![3, 6, 2, 8])); // 5
}
