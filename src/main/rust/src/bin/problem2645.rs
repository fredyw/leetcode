// https://leetcode.com/problems/minimum-additions-to-make-valid-string/
pub fn add_minimum(word: String) -> i32 {
    let mut answer = 0;
    let chars: Vec<char> = word.chars().into_iter().collect();
    let mut i = 0;
    while i < word.len() {
        if i + 1 >= chars.len() {
            answer += 2;
            break;
        }
        if chars[i] >= chars[i + 1] {
            answer += 2;
            i += 1;
            continue;
        }
        if chars[i] < chars[i + 1] {
            i += 1;
            if i >= chars.len() {
                answer += 1;
                break;
            }
            if i + 1 >= chars.len() {
                answer += 1;
                break;
            }
            if chars[i] >= chars[i + 1] {
                answer += 1;
                i += 1;
                continue;
            }
            if chars[i] < chars[i + 1] {
                i += 1;
            }
        }
        i += 1;
    }
    answer
}

fn main() {
    println!("{}", add_minimum("b".to_string())); // 2
    println!("{}", add_minimum("aaa".to_string())); // 6
    println!("{}", add_minimum("abc".to_string())); // 0
    println!("{}", add_minimum("aaabbcaccaacca".to_string())); // 16
    println!("{}", add_minimum("aaaaab".to_string())); // 16
    println!("{}", add_minimum("ab".to_string())); // 1
}
