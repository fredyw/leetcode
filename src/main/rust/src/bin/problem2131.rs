// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
pub fn longest_palindrome(words: Vec<String>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        longest_palindrome(vec!["lc".to_string(), "cl".to_string(), "gg".to_string()])
    ); // 6
    println!(
        "{}",
        longest_palindrome(vec![
            "ab".to_string(),
            "ty".to_string(),
            "yt".to_string(),
            "lc".to_string(),
            "cl".to_string(),
            "ab".to_string()
        ])
    ); // 8
    println!(
        "{}",
        longest_palindrome(vec!["cc".to_string(), "ll".to_string(), "xx".to_string()])
    ); // 2
}
