// https://leetcode.com/problems/find-maximum-number-of-string-pairs/
pub fn maximum_number_of_string_pairs(words: Vec<String>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        maximum_number_of_string_pairs(vec![
            "cd".to_string(),
            "ac".to_string(),
            "dc".to_string(),
            "ca".to_string(),
            "zz".to_string()
        ])
    ); // 2
    println!(
        "{}",
        maximum_number_of_string_pairs(vec!["ab".to_string(), "ba".to_string(), "cc".to_string()])
    ); // 1
    println!(
        "{}",
        maximum_number_of_string_pairs(vec!["aa".to_string(), "ab".to_string(),])
    ); // 0
}
