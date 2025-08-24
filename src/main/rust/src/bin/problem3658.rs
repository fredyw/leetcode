// https://leetcode.com/problems/gcd-of-odd-and-even-sums/description/
pub fn gcd_of_odd_even_sums(n: i32) -> i32 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            gcd(b, a % b)
        }
    }

    let mut sum_odd = 0;
    let mut x = 1;
    for _ in 0..n {
        sum_odd += x;
        x += 2;
    }
    let mut sum_even = 0;
    let mut x = 2;
    for _ in 0..n {
        sum_even += x;
        x += 2;
    }
    gcd(sum_odd, sum_even)
}

fn main() {
    println!("{}", gcd_of_odd_even_sums(4)); // 4
    println!("{}", gcd_of_odd_even_sums(5)); // 5
}
