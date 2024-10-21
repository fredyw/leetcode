// https://leetcode.com/problems/maximum-number-that-makes-result-of-bitwise-and-zero/description/
pub fn max_number(n: i64) -> i64 {
    let mut answer = 0;
    let mut and = 0;
    for i in (0..=n).rev() {
        if i == n {
            and = i;
        } else {
            and &= i;
        }
        if and == 0 {
            answer = i;
            break;
        }
    }
    answer
}

fn main() {
    println!("{}", max_number(7)); // 3
    println!("{}", max_number(9)); // 7
    println!("{}", max_number(17)); // 15
}
