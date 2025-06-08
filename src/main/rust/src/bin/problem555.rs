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
    println!("{}", split_looped_string(vec!["xyz".to_string()])); // "zyx"
    println!(
        "{}",
        split_looped_string(vec![
            "abc".to_string(),
            "def".to_string(),
            "xyz".to_string()
        ])
    ); // "zyxcbafed"
    println!(
        "{}",
        split_looped_string(vec![
            "xab".to_string(),
            "axz".to_string(),
            "xyz".to_string()
        ])
    ); // "zzyxxabax"
    println!(
        "{}",
        split_looped_string(vec!["a".to_string(), "b".to_string(), "c".to_string()])
    ); // "cab"
}
