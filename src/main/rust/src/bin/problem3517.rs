// https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
pub fn smallest_palindrome(s: String) -> String {
    let mut chars: Vec<char> = s.chars().collect();
    chars.sort();
    let mut answer = vec![' '; s.len()];
    let mut i = 0;
    let mut j = 0;
    let mut mid = ' ';
    while i < chars.len() {
        if i + 1 < chars.len() && chars[i] != chars[i + 1] {
            mid = chars[i];
            i += 1;
        }
        answer[j] = chars[i];
        if i + 1 < chars.len() {
            answer[chars.len() - j - 1] = chars[i + 1];
        }
        i += 2;
        j += 1;
    }
    if mid != ' ' {
        answer[j] = mid;
    }
    answer.iter().collect()
}

fn main() {
    println!("{}", smallest_palindrome("z".to_string())); // "z"
    println!("{}", smallest_palindrome("babab".to_string())); // "abbba"
    println!("{}", smallest_palindrome("daccad".to_string())); // "acddca"
    println!("{}", smallest_palindrome("yey".to_string())); // "yey"
    println!("{}", smallest_palindrome("abbcc".to_string())); // "bcacb"
}
