// https://leetcode.com/problems/one-edit-distance/description/
pub fn is_one_edit_distance(s: String, t: String) -> bool {
    if s == t || (s.len() as i32 - t.len() as i32).abs() > 1 {
        return false;
    }
    let s: Vec<char> = s.chars().collect();
    let t: Vec<char> = t.chars().collect();
    let mut i = 0;
    let mut j = 0;
    let mut count = 0;
    while i < s.len() && j < t.len() {
        if s[i] != t[j] {
            count += 1;
            if s.len() == t.len() {
                i += 1;
                j += 1;
            } else if s.len() > t.len() {
                i += 1;
            } else {
                j += 1;
            }
        } else {
            i += 1;
            j += 1;
        }
        if count > 1 {
            return false;
        }
    }
    if count == 0 {
        s.len() - i == 1 || t.len() - j == 1
    } else {
        count == 1
    }
}

fn main() {
    println!(
        "{}",
        is_one_edit_distance("ab".to_string(), "acb".to_string())
    ); // true
    println!("{}", is_one_edit_distance("".to_string(), "".to_string())); // false
    println!(
        "{}",
        is_one_edit_distance("ab".to_string(), "a".to_string())
    ); // true
    println!(
        "{}",
        is_one_edit_distance("ab".to_string(), "ar".to_string())
    ); // true
    println!("{}", is_one_edit_distance("a".to_string(), "".to_string())); // true
    println!(
        "{}",
        is_one_edit_distance("ab".to_string(), "ab".to_string())
    ); // false
    println!(
        "{}",
        is_one_edit_distance("aaaaaaaaa".to_string(), "aaaaaaaaaa".to_string())
    ); // true
    println!(
        "{}",
        is_one_edit_distance("a".to_string(), "aa".to_string())
    ); // true
    println!(
        "{}",
        is_one_edit_distance("aa".to_string(), "a".to_string())
    ); // true
    println!(
        "{}",
        is_one_edit_distance("aca".to_string(), "caca".to_string())
    ); // true
}
