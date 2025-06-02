// https://leetcode.com/problems/split-concatenated-strings/description/
pub fn split_looped_string(strs: Vec<String>) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        split_looped_string(vec!["abc".to_string(), "xyz".to_string()])
    ); // "zyxcba"
    println!("{}", split_looped_string(vec!["abc".to_string()])); // "cba"
}
