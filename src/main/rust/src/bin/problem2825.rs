// https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/description/
pub fn can_make_subsequence(str1: String, str2: String) -> bool {
    todo!()
}

fn main() {
    println!("{}", can_make_subsequence("abc".to_string(), "ad".to_string())); // true
    println!("{}", can_make_subsequence("zc".to_string(), "ad".to_string())); // true
    println!("{}", can_make_subsequence("ab".to_string(), "d".to_string())); // false
}
