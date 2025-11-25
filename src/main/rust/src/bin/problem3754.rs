// https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/
pub fn sum_and_multiply(n: i32) -> i64 {
    let mut sum = 0;
    let mut s = String::new();
    for c in n.to_string().chars() {
        if c != '0' {
            sum += c.to_digit(10).unwrap() as i64;
            s.push(c);
        }
    }
    s.parse::<i64>().unwrap_or(0) * sum
}

fn main() {
    println!("{}", sum_and_multiply(10203004)); // 12340
    println!("{}", sum_and_multiply(1000)); // 1
}
