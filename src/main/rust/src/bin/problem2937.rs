// https://leetcode.com/problems/make-three-strings-equal/description/
pub fn find_minimum_operations(s1: String, s2: String, s3: String) -> i32 {
    let mut same = false;
    let s1 = s1.as_bytes();
    let s2 = s2.as_bytes();
    let s3 = s3.as_bytes();
    let mut i = 0;
    while i < s1.len() && i < s2.len() && i < s3.len() {
        if !(s1[i] == s2[i] && s2[i] == s3[i]) {
            break;
        }
        same = true;
        i += 1;
    }
    if !same {
        return -1;
    }
    let a = if i <= s1.len() { s1.len() - i } else { 0 };
    let b = if i <= s2.len() { s2.len() - i } else { 0 };
    let c = if i <= s3.len() { s3.len() - i } else { 0 };
    (a + b + c) as i32
}

fn main() {
    println!(
        "{}",
        find_minimum_operations("abc".to_string(), "abb".to_string(), "ab".to_string())
    ); // 2
    println!(
        "{}",
        find_minimum_operations("dac".to_string(), "bac".to_string(), "cac".to_string())
    ); // -1
    println!(
        "{}",
        find_minimum_operations("abc".to_string(), "abc".to_string(), "abc".to_string())
    ); // 0
    println!(
        "{}",
        find_minimum_operations(
            "abcxsw".to_string(),
            "abcxsd".to_string(),
            "abcxksdk".to_string()
        )
    ); // 8
}
