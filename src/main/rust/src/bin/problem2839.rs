// https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/
pub fn can_be_equal(s1: String, s2: String) -> bool {
    let mut chars1: Vec<char> = s1.chars().collect();
    let chars2: Vec<char> = s2.chars().collect();
    let mut i = 0;
    while i < chars1.len() {
        if chars1[i] != chars2[i] {
            if i + 2 >= chars1.len() {
                return false;
            }
            let tmp = chars1[i];
            chars1[i] = chars1[i + 2];
            chars1[i + 2] = tmp;
            if chars1[i] != chars2[i] || chars1[i + 2] != chars2[i + 2] {
                return false;
            }
        }
        i += 1;
    }
    true
}

fn main() {
    println!("{}", can_be_equal("abcd".to_string(), "cdab".to_string())); // true
    println!("{}", can_be_equal("abcd".to_string(), "dacb".to_string())); // false
    println!("{}", can_be_equal("lpsc".to_string(), "cslp".to_string())); // false
}
