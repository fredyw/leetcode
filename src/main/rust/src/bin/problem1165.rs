// https://leetcode.com/problems/single-row-keyboard/description/
pub fn calculate_time(keyboard: String, word: String) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        calculate_time("abcdefghijklmnopqrstuvwxyz".to_string(), "cba".to_string())
    ); // 4
    println!(
        "{}",
        calculate_time(
            "pqrstuvwxyzabcdefghijklmno".to_string(),
            "leetcode".to_string()
        )
    ); // 73
}
