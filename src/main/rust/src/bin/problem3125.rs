// https://leetcode.com/problems/maximum-number-that-makes-result-of-bitwise-and-zero/description/
pub fn max_number(n: i64) -> i64 {
    let mut i = n;
    let mut count = 0;
    while i > 0 {
        i = i >> 1;
        count += 1;
    }
    let mut answer = 0;
    for i in 0..count - 1 {
        answer = answer | (1 << i);
    }
    answer
}

fn main() {
    println!("{}", max_number(7)); // 3
    println!("{}", max_number(9)); // 7
    println!("{}", max_number(17)); // 15
}
