// https://leetcode.com/problems/valid-digit-number/description/
pub fn valid_digit(n: i32, x: i32) -> bool {
    let x = std::char::from_digit(x as u32, 10).unwrap();
    let n = n.to_string();
    n.contains(x) && !n.starts_with(x)
}

fn main() {
    println!("{}", valid_digit(101, 0)); // true
    println!("{}", valid_digit(232, 2)); // false
    println!("{}", valid_digit(5, 1)); // false
}
