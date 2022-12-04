// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/
pub fn append_characters(s: String, t: String) -> i32 {
    let mut i = 0;
    let mut j = 0;
    let s: Vec<char> = s.chars().collect();
    let t: Vec<char> = t.chars().collect();
    while j < t.len() {
        while i < s.len() && s[i] != t[j] {
            i += 1;
        }
        if i == s.len() {
            break;
        }
        i += 1;
        j += 1;
    }
    (t.len() - j) as i32
}

fn main() {
    println!(
        "{}",
        append_characters("coaching".to_string(), "coding".to_string())
    ); // 4
    println!(
        "{}",
        append_characters("abcde".to_string(), "a".to_string())
    ); // 0
    println!(
        "{}",
        append_characters("z".to_string(), "abcde".to_string())
    ); // 5
}
