use itertools::Itertools;

// https://leetcode.com/problems/check-ascii-palindromic/description/
pub fn is_palindromic(s: String) -> bool {
    let binary_string = s
        .chars()
        .map(|c| format!("{:08b}", c as u8))
        .join("")
        .chars()
        .collect::<Vec<char>>();
    let mut i = 0;
    let mut j = binary_string.len() - 1;
    while i < j {
        if binary_string[i] != binary_string[j] {
            return false;
        }
        i += 1;
        j -= 1;
    }
    true
}

fn main() {
    println!("{}", is_palindromic("ff".to_string())); // true
    println!("{}", is_palindromic("leet".to_string())); // false
}
