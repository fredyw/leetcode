// https://leetcode.com/problems/maximum-odd-binary-number/description/
pub fn maximum_odd_binary_number(s: String) -> String {
    let count = s.chars().filter(|c| *c == '1').count();
    let mut answer = String::new();
    for i in 0..count - 1 {
        answer.push('1');
    }
    for i in 0..s.len() - count {
        answer.push('0');
    }
    answer.push('1');
    answer
}

fn main() {
    println!("{}", maximum_odd_binary_number("010".to_string())); // "001"
    println!("{}", maximum_odd_binary_number("0101".to_string())); // "1001"
    println!(
        "{}",
        maximum_odd_binary_number("100011110101001".to_string())
    ); // "111111100000001"
}
