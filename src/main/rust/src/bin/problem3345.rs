// https://leetcode.com/problems/smallest-divisible-digit-product-i/description/
pub fn smallest_number(n: i32, t: i32) -> i32 {
    fn product(n: i32) -> i32 {
        n.to_string()
            .chars()
            .map(|c| c.to_digit(10).unwrap() as i32)
            .product()
    }

    let mut answer = n;
    while product(answer) % t != 0 {
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", smallest_number(10, 2)); // 10
    println!("{}", smallest_number(15, 3)); // 16
}
