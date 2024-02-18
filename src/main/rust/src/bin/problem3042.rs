// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/
pub fn count_prefix_suffix_pairs(words: Vec<String>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        count_prefix_suffix_pairs(vec![
            "a".to_string(),
            "aba".to_string(),
            "ababa".to_string(),
            "aa".to_string()
        ])
    ); // 4
    println!(
        "{}",
        count_prefix_suffix_pairs(vec![
            "pa".to_string(),
            "papa".to_string(),
            "ma".to_string(),
            "mama".to_string()
        ])
    ); // 2
    println!(
        "{}",
        count_prefix_suffix_pairs(vec!["abab".to_string(), "ab".to_string()])
    ); // 0
}
