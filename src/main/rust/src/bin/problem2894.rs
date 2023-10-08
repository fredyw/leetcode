// https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/
pub fn difference_of_sums(n: i32, m: i32) -> i32 {
    let mut num1 = 0;
    let mut num2 = 0;
    for i in 1..=n {
        if i % m != 0 {
            num1 += i;
        } else {
            num2 += i;
        }
    }
    num1 - num2
}

fn main() {
    println!("{}", difference_of_sums(10, 3)); // 19
    println!("{}", difference_of_sums(5, 6)); // 15
    println!("{}", difference_of_sums(5, 1)); // -15
}
