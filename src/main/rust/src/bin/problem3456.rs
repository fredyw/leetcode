// https://leetcode.com/problems/find-special-substring-of-length-k/description/
pub fn has_special_substring(s: String, k: i32) -> bool {
    let bytes = s.as_bytes();
    let mut i = 0;
    let mut len = 1;
    while i < bytes.len() - 1 {
        if bytes[i] == bytes[i + 1] {
            len += 1;
        } else {
            if len == k {
                return true;
            }
            len = 1;
        }
        i += 1;
    }
    if len == k {
        true
    } else {
        false
    }
}

fn main() {
    println!("{}", has_special_substring("aaabaaa".to_string(), 3)); // true
    println!("{}", has_special_substring("abc".to_string(), 2)); // false
    println!("{}", has_special_substring("aabaaa".to_string(), 3)); // true
}
