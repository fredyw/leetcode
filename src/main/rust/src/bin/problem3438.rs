// https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/description/
pub fn find_valid_pair(s: String) -> String {
    let mut counts: Vec<i32> = vec![0; 10];
    let bytes = s.as_bytes();
    for i in 0..bytes.len() {
        counts[bytes[i] as usize - '0' as usize] += 1;
    }
    for i in 0..bytes.len() - 1 {
        if bytes[i] != bytes[i + 1] {
            if counts[bytes[i] as usize - '0' as usize] == (bytes[i] - '0' as u8) as i32
                && counts[bytes[i + 1] as usize - '0' as usize] == (bytes[i + 1] - '0' as u8) as i32
            {
                return s[i..i + 2].to_string();
            }
        }
    }
    "".to_string()
}

fn main() {
    println!("{}", find_valid_pair("2523533".to_string())); // "23"
    println!("{}", find_valid_pair("221".to_string())); // "21"
    println!("{}", find_valid_pair("22".to_string())); // ""
}
