// https://leetcode.com/problems/longest-common-prefix-after-at-most-one-removal/description/
pub fn longest_common_prefix(s: String, t: String) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        longest_common_prefix("madxa".to_string(), "madam".to_string())
    ); // 4
    println!(
        "{}",
        longest_common_prefix("leetcode".to_string(), "eetcode".to_string())
    ); // 3
    println!(
        "{}",
        longest_common_prefix("one".to_string(), "one".to_string())
    ); // 3
    println!(
        "{}",
        longest_common_prefix("a".to_string(), "b".to_string())
    ); // 0
    println!(
        "{}",
        longest_common_prefix("abc".to_string(), "bmn".to_string())
    ); // 1
}
