// https://leetcode.com/problems/add-bold-tag-in-string/
pub fn add_bold_tag(s: String, words: Vec<String>) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        add_bold_tag(
            "abcxyz123".to_string(),
            vec!["abc".to_string(), "123".to_string()]
        )
    ); // "<b>abc</b>xyz<b>123</b>"
    println!(
        "{}",
        add_bold_tag(
            "aaabbb".to_string(),
            vec!["aa".to_string(), "b".to_string()]
        )
    ); // "<b>aaabbb</b>"
    println!(
        "{}",
        add_bold_tag("aaaaa".to_string(), vec!["aaaa".to_string()])
    ); // "<b>aaaaa</b>"
}
