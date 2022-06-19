// https://leetcode.com/problems/largest-merge-of-two-strings/
pub fn largest_merge(word1: String, word2: String) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        largest_merge(String::from("cabaa"), String::from("bcaaa"))
    ); // "cbcabaaaaa"
    println!(
        "{}",
        largest_merge(String::from("abcabc"), String::from("abdcaba"))
    ); // "abdcabcabcaba"
    println!(
        "{}",
        largest_merge(String::from("abb"), String::from("acde"))
    ); // "acdeabb"
}
