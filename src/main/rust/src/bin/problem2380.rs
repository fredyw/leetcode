// https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/
pub fn seconds_to_remove_occurrences(s: String) -> i32 {
    let mut answer = 0;
    let mut chars: Vec<char> = s.chars().collect();
    let mut i = 0;
    while i < chars.len() - 1 {
        if chars[i] == '0' && chars[i + 1] == '1' {
            chars.swap(i, i + 1);
            answer += 1;
        }
        i += 1;
    }
    answer
}

fn main() {
    println!("{}", seconds_to_remove_occurrences("0110101".to_string())); // 4
    println!("{}", seconds_to_remove_occurrences("11100".to_string())); // 0
    println!(
        "{}",
        seconds_to_remove_occurrences("1000111001010010010101010101".to_string())
    ); // 15
}
