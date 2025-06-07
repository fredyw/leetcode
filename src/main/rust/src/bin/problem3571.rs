// https://leetcode.com/problems/find-the-shortest-superstring-ii/description/
pub fn shortest_superstring(s1: String, s2: String) -> String {
    if s1.contains(&s2) {
        return s1;
    }
    if s2.contains(&s1) {
        return s2;
    }
    let mut string1 = "".to_string();
    for i in 0..s1.len() {
        let sub = &s1[i..];
        if s2.starts_with(sub) {
            string1 = format!("{}{}", s1, &s2[sub.len()..]);
            break;
        }
    }
    let mut string2 = "".to_string();
    for i in 0..s2.len() {
        let sub = &s2[i..];
        if s1.starts_with(sub) {
            string2 = format!("{}{}", s2, &s1[sub.len()..]);
            break;
        }
    }
    if string1.is_empty() && string2.is_empty() {
        format!("{}{}", s1, s2)
    } else if string1.len() < string2.len() {
        if string1.is_empty() {
            string2
        } else {
            string1
        }
    } else {
        if string2.is_empty() {
            string1
        } else {
            string2
        }
    }
}

fn main() {
    println!(
        "{}",
        shortest_superstring("aba".to_string(), "bab".to_string())
    ); // "abab"
    println!(
        "{}",
        shortest_superstring("aa".to_string(), "aaa".to_string())
    ); // "aaa"
    println!(
        "{}",
        shortest_superstring("abc".to_string(), "xyz".to_string())
    ); // "abcxyz"
    println!(
        "{}",
        shortest_superstring("aba".to_string(), "bax".to_string())
    ); // "abax"
    println!(
        "{}",
        shortest_superstring("m".to_string(), "azmvzfh".to_string())
    ); // "azmvzfh"
}
