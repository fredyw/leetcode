// https://leetcode.com/problems/armstrong-number/description/
pub fn is_armstrong(n: i32) -> bool {
    let s = format!("{n}");
    s.chars()
        .map(|c| (c as i32 - '0' as i32).pow(s.len() as u32))
        .sum::<i32>()
        == n
}

fn main() {
    println!("{}", is_armstrong(153)); // true
    println!("{}", is_armstrong(123)); // false
    println!("{}", is_armstrong(2)); // true
}
