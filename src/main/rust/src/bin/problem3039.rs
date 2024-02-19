// https://leetcode.com/problems/apply-operations-to-make-string-empty/description/
pub fn last_non_empty_string(s: String) -> String {
    todo!()
}

fn main() {
    println!("{}", last_non_empty_string("aabcbbca".to_string())); // "ba"
    println!("{}", last_non_empty_string("abcd".to_string())); // "abcd"
    println!("{}", last_non_empty_string("abbccc".to_string())); // "c"
}
