// https://leetcode.com/problems/valid-palindrome-iv/description/
pub fn make_palindrome(s: String) -> bool {
    let bytes = s.as_bytes();
    let mut i = 0;
    let mut j = s.len() - 1;
    let mut n = 2;
    while i < j {
        if bytes[i] != bytes[j] {
            if n == 0 {
                return false;
            }
            n -= 1;
        }
        i += 1;
        j -= 1;
    }
    true
}

fn main() {
    println!("{}", make_palindrome("abcdba".to_string())); // true
    println!("{}", make_palindrome("aa".to_string())); // true
    println!("{}", make_palindrome("abcdef".to_string())); // false
}
