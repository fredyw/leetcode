// https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/
pub fn find_the_longest_balanced_substring(s: String) -> i32 {
    let mut answer = 0;
    let mut i = 0;
    let chars: Vec<char> = s.chars().collect();
    while i < chars.len() {
        let mut zero_count = 0;
        while i < chars.len() && chars[i] == '0' {
            zero_count += 1;
            i += 1;
        }
        let mut one_count = 0;
        while i < chars.len() && chars[i] == '1' {
            one_count += 1;
            i += 1;
        }
        answer = answer.max(zero_count.min(one_count) * 2);
    }
    answer
}

fn main() {
    println!(
        "{}",
        find_the_longest_balanced_substring("01000111".to_string())
    ); // 6
    println!(
        "{}",
        find_the_longest_balanced_substring("00111".to_string())
    ); // 4
    println!("{}", find_the_longest_balanced_substring("111".to_string())); // 0
}
