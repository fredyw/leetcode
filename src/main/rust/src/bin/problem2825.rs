// https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/description/
pub fn can_make_subsequence(str1: String, str2: String) -> bool {
    let mut i = 0;
    let mut j = 0;
    let bytes1 = str1.as_bytes();
    let bytes2 = str2.as_bytes();
    while i < bytes1.len() && j < bytes2.len() {
        let n1 = bytes1[i] - 'a' as u8;
        let n2 = bytes2[j] - 'a' as u8;
        if n1 == n2 || (n1 + 1) % 26 == n2 {
            j += 1;
        }
        i += 1;
    }
    j == bytes2.len()
}

fn main() {
    println!(
        "{}",
        can_make_subsequence("abc".to_string(), "ad".to_string())
    ); // true
    println!(
        "{}",
        can_make_subsequence("zc".to_string(), "ad".to_string())
    ); // true
    println!(
        "{}",
        can_make_subsequence("ab".to_string(), "d".to_string())
    ); // false
}
