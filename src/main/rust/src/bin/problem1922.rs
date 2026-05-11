// https://leetcode.com/problems/count-good-numbers/description/
pub fn count_good_numbers(n: i64) -> i32 {
    fn mod_pow(mut base: i64, mut exp: i64, m: i64) -> i64 {
        let mut result = 1;
        base %= m;
        while exp > 0 {
            if exp % 2 == 1 {
                result = (result * base) % m;
            }
            base = (base * base) % m;
            exp /= 2;
        }
        result
    }

    let m = 1_000_000_007i64;
    let even_exp = (n + 1) / 2;
    let odd_exp = n / 2;
    let evens = mod_pow(5, even_exp, m); // 5 because [0, 2, 4, 6, 8]
    let primes = mod_pow(4, odd_exp, m); // 4 because [2, 3, 5, 7]
    ((evens * primes) % m) as i32
}

fn main() {
    println!("{}", count_good_numbers(1)); // 5
    println!("{}", count_good_numbers(4)); // 400
    println!("{}", count_good_numbers(50)); // 564908303
}
