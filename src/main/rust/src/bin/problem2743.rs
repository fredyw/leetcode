use std::collections::HashSet;

// https://leetcode.com/problems/count-substrings-without-repeating-character/description/
pub fn number_of_special_substrings(s: String) -> i32 {
    fn series(n: i32) -> i32 {
        (n * (1 + n)) / 2
    }

    let mut answer = 0;
    let bytes = s.as_bytes();
    let mut set: HashSet<u8> = HashSet::new();
    let mut curr = 0;
    let mut prev = 0;
    while curr < bytes.len() {
        if set.contains(&bytes[curr]) {
            answer += series((curr - prev) as i32);
            set.remove(&bytes[prev]);
            prev += 1;
            answer -= series((curr - prev) as i32);
        } else {
            set.insert(bytes[curr]);
            curr += 1;
        }
    }
    answer += series((curr - prev) as i32);
    answer
}

fn main() {
    println!("{}", number_of_special_substrings("abcd".to_string())); // 10
    println!("{}", number_of_special_substrings("ooo".to_string())); // 3
    println!("{}", number_of_special_substrings("abab".to_string())); // 7
    println!("{}", number_of_special_substrings("abcde".to_string())); // 15
    println!("{}", number_of_special_substrings("abc".to_string())); // 6
    println!("{}", number_of_special_substrings("abcabcabc".to_string())); // 24
    println!("{}", number_of_special_substrings("abcbcb".to_string())); // 12
}
