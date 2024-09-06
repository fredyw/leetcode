// https://leetcode.com/problems/number-of-self-divisible-permutations/description/
pub fn self_divisible_permutation_count(n: i32) -> i32 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            gcd(b, a % b)
        }
    }

    todo!()
}

fn main() {
    println!("{}", self_divisible_permutation_count(1)); // 1
    println!("{}", self_divisible_permutation_count(2)); // 1
    println!("{}", self_divisible_permutation_count(3)); // 3
}
