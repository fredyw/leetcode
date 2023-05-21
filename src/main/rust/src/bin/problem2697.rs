// https://leetcode.com/problems/lexicographically-smallest-palindrome/
pub fn make_smallest_palindrome(s: String) -> String {
    let mut answer: Vec<char> = vec![' '; s.len()];
    let chars: Vec<char> = s.chars().collect();
    let mut i = 0;
    let mut j = s.len() as i32 - 1;
    while i <= j {
        if chars[i as usize] < chars[j as usize] {
            answer[i as usize] = chars[i as usize];
            answer[j as usize] = chars[i as usize];
        } else if chars[i as usize] > chars[j as usize] {
            answer[i as usize] = chars[j as usize];
            answer[j as usize] = chars[j as usize];
        } else {
            answer[i as usize] = chars[i as usize];
            answer[j as usize] = chars[j as usize];
        }
        i += 1;
        j -= 1;
    }
    answer.into_iter().collect()
}

fn main() {
    println!("{}", make_smallest_palindrome("egcfe".to_string())); // "efcfe"
    println!("{}", make_smallest_palindrome("abcd".to_string())); // "abba"
    println!("{}", make_smallest_palindrome("seven".to_string())); // "neven"
    println!("{}", make_smallest_palindrome("s".to_string())); // "s"
}
