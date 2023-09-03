// https://leetcode.com/problems/extra-characters-in-a-string/
pub fn min_extra_char(s: String, dictionary: Vec<String>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        min_extra_char(
            "leetscode".to_string(),
            vec![
                "leet".to_string(),
                "code".to_string(),
                "leetcode".to_string()
            ]
        )
    ); // 1
    println!(
        "{}",
        min_extra_char(
            "sayhelloworld".to_string(),
            vec!["hello".to_string(), "world".to_string()]
        )
    ); // 3
}
