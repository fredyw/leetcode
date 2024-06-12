// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
pub fn min_insertions(s: String) -> i32 {
    let mut answer = 0;
    let bytes = s.as_bytes();
    let mut i = 0;
    let mut j = s.len() - 1;
    while i < j {
        if bytes[i] != bytes[j] {
            i += 1;
            answer += 1;
        } else {
            i += 1;
            j -= 1;
        }
    }
    answer
}

fn main() {
    println!("{}", min_insertions("zzazz".to_string())); // 0
    println!("{}", min_insertions("mbadm".to_string())); // 2
    println!("{}", min_insertions("leetcode".to_string())); // 5
    println!("{}", min_insertions("zjveiiwvc".to_string())); // 5
}
