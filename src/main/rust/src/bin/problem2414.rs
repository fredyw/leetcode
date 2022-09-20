// https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
pub fn longest_continuous_substring(s: String) -> i32 {
    let mut answer = 1;
    let bytes = s.as_bytes();
    let mut length = 1;
    for i in 0..bytes.len() - 1 {
        if bytes[i] + 1 == bytes[i + 1] {
            length += 1;
        } else {
            length = 1;
        }
        answer = answer.max(length);
    }
    answer
}

fn main() {
    println!("{}", longest_continuous_substring("abacaba".to_string())); // 2
    println!("{}", longest_continuous_substring("abcde".to_string())); // 5
    println!(
        "{}",
        longest_continuous_substring("xyziabcdefmnrvx".to_string())
    ); // 6
    println!(
        "{}",
        longest_continuous_substring("abcdefghijklmnopqrstuvwxyz".to_string())
    ); // 26
}
