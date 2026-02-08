// https://leetcode.com/problems/reverse-letters-then-special-characters-in-a-string/description/
pub fn reverse_by_type(s: String) -> String {
    let mut chars: Vec<char> = s.chars().collect();
    let mut i = 0;
    let mut j = chars.len() - 1;
    while i < j {
        if chars[i].is_ascii_alphabetic() && chars[j].is_ascii_alphabetic() {
            chars.swap(i, j);
            i += 1;
            j -= 1;
        }
        if !chars[i].is_ascii_alphabetic() {
            i += 1;
        }
        if !chars[j].is_ascii_alphabetic() {
            j -= 1;
        }
    }
    let mut i = 0;
    let mut j = chars.len() - 1;
    while i < j {
        if !chars[i].is_ascii_alphabetic() && !chars[j].is_ascii_alphabetic() {
            chars.swap(i, j);
            i += 1;
            j -= 1;
        }
        if chars[i].is_ascii_alphabetic() {
            i += 1;
        }
        if chars[j].is_ascii_alphabetic() {
            j -= 1;
        }
    }
    chars.into_iter().collect()
}

fn main() {
    println!("{}", reverse_by_type(")ebc#da@f(".to_string())); // "(fad@cb#e)"
    println!("{}", reverse_by_type("z".to_string())); // "z"
    println!("{}", reverse_by_type("!@#$%^&*()".to_string())); // ")(*&^%$#@!"
}
