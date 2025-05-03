// https://leetcode.com/problems/one-edit-distance/description/
pub fn is_one_edit_distance(s: String, t: String) -> bool {
    let s: Vec<char> = s.chars().collect();
    let t: Vec<char> = t.chars().collect();
    let mut i = 0;
    let mut j = 0;
    while i < s.len() && j < t.len() {
        if s[i] != t[j] {}
    }
    todo!()
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
}
