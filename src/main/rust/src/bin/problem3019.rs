// https://leetcode.com/problems/number-of-changing-keys/description/
pub fn count_key_changes(s: String) -> i32 {
    let mut answer = 0;
    let chars: Vec<char> = s.chars().collect();
    for i in 0..s.len() - 1 {
        if chars[i].to_lowercase().to_string() != chars[i + 1].to_lowercase().to_string() {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", count_key_changes("aAbBcC".to_string())); // 2
    println!("{}", count_key_changes("AaAaAaaA".to_string())); // 0
    println!("{}", count_key_changes("mDVD".to_string())); // 3
}
