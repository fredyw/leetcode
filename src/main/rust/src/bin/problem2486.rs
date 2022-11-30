// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/
pub fn append_characters(s: String, t: String) -> i32 {
    todo!()
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
