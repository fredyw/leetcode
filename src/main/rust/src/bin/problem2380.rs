// https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/
pub fn seconds_to_remove_occurrences(s: String) -> i32 {
    let mut answer = 0;
    let mut chars: Vec<char> = s.chars().collect();
    loop {
        let mut i = 0;
        let mut count = 0;
        while i < chars.len() - 1 {
            if chars[i] == '0' && chars[i + 1] == '1' {
                chars.swap(i, i + 1);
                count += 1;
            }
            i += 1;
        }
        if count == 0 {
            break;
        }
        answer += 1;
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
    println!("{}", seconds_to_remove_occurrences("1100101".to_string())); // 3
}
