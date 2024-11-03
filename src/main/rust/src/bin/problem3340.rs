// https://leetcode.com/problems/check-balanced-string/description/
pub fn is_balanced(num: String) -> bool {
    let chars: Vec<char> = num.chars().collect();
    let even_sum: i32 = chars
        .iter()
        .enumerate()
        .filter(|(i, _)| i % 2 == 0)
        .map(|(_, c)| *c as i32 - '0' as i32)
        .sum();
    let odd_sum: i32 = chars
        .iter()
        .enumerate()
        .filter(|(i, _)| i % 2 != 0)
        .map(|(_, c)| *c as i32 - '0' as i32)
        .sum();
    even_sum == odd_sum
}

fn main() {
    println!("{}", is_balanced("1234".to_string())); // false
    println!("{}", is_balanced("24123".to_string())); // true
}
