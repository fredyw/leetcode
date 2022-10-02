// https://leetcode.com/problems/number-of-common-factors/
pub fn common_factors(a: i32, b: i32) -> i32 {
    let mut answer = 0;
    for i in 1..=a.min(b) {
        answer += if a % i == 0 && b % i == 0 { 1 } else { 0 };
    }
    answer
}

fn main() {
    println!("{}", common_factors(12, 6)); // 4
    println!("{}", common_factors(25, 30)); // 2
    println!("{}", common_factors(8, 12)); // 3
    println!("{}", common_factors(50, 48)); // 2
    println!("{}", common_factors(50, 45)); // 2
    println!("{}", common_factors(12, 24)); // 6
}
