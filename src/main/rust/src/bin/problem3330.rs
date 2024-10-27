// https://leetcode.com/problems/find-the-original-typed-string-i/description/
pub fn possible_string_count(word: String) -> i32 {
    let mut answer = 1;
    let bytes = word.as_bytes();
    let mut i = 0;
    let mut length = 1;
    while i < bytes.len() - 1 {
        if bytes[i] == bytes[i + 1] {
            length += 1;
        } else {
            if length > 1 {
                answer += length - 1;
            }
            length = 1;
        }
        i += 1;
    }
    if length > 1 {
        answer += length - 1;
    }
    answer
}

fn main() {
    println!("{}", possible_string_count("abbcccc".to_string())); // 5
    println!("{}", possible_string_count("abcd".to_string())); // 1
    println!("{}", possible_string_count("aaaa".to_string())); // 4
    println!("{}", possible_string_count("aabbb".to_string())); // 4
    println!("{}", possible_string_count("ere".to_string())); // 1
}
