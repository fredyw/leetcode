// https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
pub fn longest_continuous_substring(s: String) -> i32 {
    todo!()
}

fn main() {
    println!("{}", longest_continuous_substring("abacaba".to_string())); // 2
    println!("{}", longest_continuous_substring("abcde".to_string())); // 5
    println!(
        "{}",
        longest_continuous_substring("xyziabcdefmnrvx".to_string())
    ); // 6
}
