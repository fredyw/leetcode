// https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/
pub fn is_substring_present(s: String) -> bool {
    s.chars()
        .rev()
        .collect::<Vec<char>>()
        .windows(2)
        .map(|w| w.iter().collect::<String>())
        .any(|sub| s.contains(&sub))
}

fn main() {
    println!("{}", is_substring_present("leetcode".to_string())); // true
    println!("{}", is_substring_present("abcba".to_string())); // true
    println!("{}", is_substring_present("abcd".to_string())); // false
}
