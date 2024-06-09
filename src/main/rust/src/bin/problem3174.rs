// https://leetcode.com/problems/clear-digits/description/
pub fn clear_digits(s: String) -> String {
    let chars: Vec<char> = s.chars().collect();
    let mut to_be_removed: Vec<bool> = vec![false; s.len()];
    let mut i = 0;
    while i < chars.len() {
        if chars[i].is_ascii_digit() {
            to_be_removed[i] = true;
            let mut j = i - 1;
            while to_be_removed[j] {
                j -= 1;
            }
            to_be_removed[j] = true;
        }
        i += 1;
    }
    chars
        .iter()
        .enumerate()
        .filter(|(i, c)| !to_be_removed[*i])
        .map(|(_, c)| *c)
        .collect()
}

fn main() {
    println!("{}", clear_digits("abc".to_string())); // "abc"
    println!("{}", clear_digits("cb34".to_string())); // ""
    println!("{}", clear_digits("acb34".to_string())); // "a"
    println!("{}", clear_digits("acb34def5".to_string())); // "ade"
}
