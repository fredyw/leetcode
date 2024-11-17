// https://leetcode.com/problems/word-pattern-ii/description/
pub fn word_pattern_match(pattern: String, s: String) -> bool {
    todo!()
}

fn main() {
    println!(
        "{}",
        word_pattern_match("abab".to_string(), "redblueredblue".to_string())
    ); // true
    println!(
        "{}",
        word_pattern_match("aaaa".to_string(), "asdasdasdasd".to_string())
    ); // true
    println!(
        "{}",
        word_pattern_match("aabb".to_string(), "xyzabcxzyabc".to_string())
    ); // false
}
