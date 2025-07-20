// https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/description/
pub fn check_divisibility(n: i32) -> bool {
    fn digit_sum(mut n: i32) -> i32 {
        let mut sum = 0;
        while n > 0 {
            sum += n % 10;
            n /= 10;
        }
        sum
    }

    fn digit_product(mut n: i32) -> i32 {
        let mut product = 1;
        while n > 0 {
            product *= n % 10;
            n /= 10;
        }
        product
    }

    n % (digit_sum(n) + digit_product(n)) == 0
}

fn main() {
    println!("{}", check_divisibility(99)); // true
    println!("{}", check_divisibility(23)); // false
}
