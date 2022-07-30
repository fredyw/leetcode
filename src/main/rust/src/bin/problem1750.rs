// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
pub fn minimum_length(s: String) -> i32 {
    let bytes = s.as_bytes();
    let mut i = 0;
    let mut j = bytes.len() - 1;
    while i <= j && bytes[i] == bytes[j] {
        let tmp = bytes[i];
        while i <= j && bytes[i] == bytes[j] {
            i += 1;
        }
        while i <= j && tmp == bytes[j] {
            j -= 1;
        }
    }
    let answer = (j as i32 - i as i32) + 1;
    answer
}

fn main() {
    println!("{}", minimum_length("ca".to_string())); // 2
    println!("{}", minimum_length("cabaabac".to_string())); // 0
    println!("{}", minimum_length("aabccabba".to_string())); // 3
    println!(
        "{}",
        minimum_length("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb".to_string())
    ); // 1
}
