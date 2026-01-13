// https://leetcode.com/problems/largest-even-number/description/
pub fn largest_even(s: String) -> String {
    let mut i = s.len();
    while i > 0 {
        let sub = &s[0..i];
        let last = sub.as_bytes()[sub.len() - 1] as char;
        if last == '2' {
            return sub.to_string();
        }
        i -= 1;
    }
    "".to_string()
}

fn main() {
    println!("{}", largest_even("1112".to_string())); // "1112"
    println!("{}", largest_even("221".to_string())); // "22"
    println!("{}", largest_even("1".to_string())); // ""
}
