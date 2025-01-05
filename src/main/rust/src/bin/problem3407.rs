// https://leetcode.com/problems/substring-matching-pattern/
pub fn has_match(s: String, p: String) -> bool {
    todo!()
}

fn main() {
    println!("{}", has_match("leetcode".to_string(), "ee*e".to_string())); // true
    println!("{}", has_match("car".to_string(), "c*v".to_string())); // false
    println!("{}", has_match("luck".to_string(), "u*".to_string())); // true
}
