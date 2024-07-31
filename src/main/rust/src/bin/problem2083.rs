// https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter/
pub fn number_of_substrings(s: String) -> i64 {
    let mut answer: i64 = 0;
    let mut counts: Vec<i64> = vec![0; 26];
    for c in s.chars() {
        counts[c as usize - 'a' as usize] += 1;
        answer += counts[c as usize - 'a' as usize];
    }
    answer
}

fn main() {
    println!("{}", number_of_substrings("abcba".to_string())); // 7
    println!("{}", number_of_substrings("abacad".to_string())); // 9
    println!("{}", number_of_substrings("a".to_string())); // 1
}
