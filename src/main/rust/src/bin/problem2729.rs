use std::collections::HashSet;

// https://leetcode.com/problems/check-if-the-number-is-fascinating/
pub fn is_fascinating(n: i32) -> bool {
    let chars = format!("{}{}{}", n, n * 2, n * 3)
        .chars()
        .collect::<Vec<char>>();
    if chars.len() != 9 {
        return false;
    }
    chars
        .into_iter()
        .filter(|c| *c != '0')
        .collect::<HashSet<char>>()
        .len()
        == 9
}

fn main() {
    println!("{}", is_fascinating(192)); // true
    println!("{}", is_fascinating(100)); // false
    println!("{}", is_fascinating(783)); // false
}
