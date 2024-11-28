// https://leetcode.com/problems/longest-repeating-substring/description/
pub fn longest_repeating_substring(s: String) -> i32 {
    todo!()
}

fn main() {
    println!("{}", longest_repeating_substring("abcd".to_string())); // 0
    println!("{}", longest_repeating_substring("abbaba".to_string())); // 2
    println!("{}", longest_repeating_substring("aabcaabdaab".to_string())); // 3
    println!("{}", longest_repeating_substring("aa".to_string())); // 1
    println!("{}", longest_repeating_substring("aaaaa".to_string())); // 4
}
