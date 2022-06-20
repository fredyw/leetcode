// https://leetcode.com/problems/largest-merge-of-two-strings/
pub fn largest_merge(word1: String, word2: String) -> String {
    let mut answer = String::from("");
    let chars1: Vec<char> = word1.chars().collect();
    let chars2: Vec<char> = word2.chars().collect();
    let mut i = 0;
    let mut j = 0;
    while i < chars1.len() && j < chars2.len() {
        if chars1[i] > chars2[j] {
            answer.push(chars1[i]);
            i += 1;
        } else if chars1[i] < chars2[j] {
            answer.push(chars2[j]);
            j += 1;
        } else {
            answer.push(chars1[i]);
            if word1[i..] >= word2[j..] {
                i += 1;
            } else {
                j += 1;
            }
        }
    }
    if i < chars1.len() {
        answer.push_str(&word1[i..]);
    } else {
        answer.push_str(&word2[j..]);
    }
    answer
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
    println!(
        "{}",
        largest_merge(String::from("bbbaba"), String::from("bbbd"))
    ); // "bbbdbbbaba"
    println!(
        "{}",
        largest_merge(
            String::from("qqqqqqqqqeqeqqeeqqq"),
            String::from("qqqqqqqqeqqqeeqqeeqqqqqeq")
        )
    ); // "qqqqqqqqqqqqqqqqqeqqqeqeqqeeqqqeeqqeeqqqqqeq"
    println!(
        "{}",
        largest_merge(
            String::from("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"),
            String::from("bbbbbbbbbbbbbbbbbbbb")
        )
    ); // "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
}
