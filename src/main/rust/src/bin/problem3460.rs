// https://leetcode.com/problems/longest-common-prefix-after-at-most-one-removal/description/
pub fn longest_common_prefix(s: String, t: String) -> i32 {
    let s = s.as_bytes();
    let t = t.as_bytes();
    let mut answer = 0;
    let mut i = 0;
    let mut j = 0;
    let mut change = false;
    while i < s.len() && j < t.len() {
        if change && s[i] != t[j] {
            break;
        }
        if s[i] != t[j] {
            if !change {
                change = true;
            }
        } else {
            answer = answer.max(j as i32 + 1);
            j += 1;
        }
        i += 1;
    }
    answer
}

fn main() {
    println!(
        "{}",
        longest_common_prefix("madxa".to_string(), "madam".to_string())
    ); // 4
    println!(
        "{}",
        longest_common_prefix("leetcode".to_string(), "eetcode".to_string())
    ); // 7
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
    println!(
        "{}",
        longest_common_prefix("leeteetcode".to_string(), "eetcode".to_string())
    ); // 3
    println!(
        "{}",
        longest_common_prefix("dd".to_string(), "d".to_string())
    ); // 1
}
