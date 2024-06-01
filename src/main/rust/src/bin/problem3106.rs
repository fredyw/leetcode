// https://leetcode.com/problems/lexicographically-smallest-string-after-operations-with-constraint/description/
pub fn get_smallest_string(s: String, k: i32) -> String {
    let mut answer: Vec<char> = s.chars().collect();
    let mut n = k;
    for (i, c) in s.chars().enumerate() {
        if n == 0 {
            break;
        }
        let a = (c as i32 - 'a' as i32).abs();
        let b = (c as i32 - ('a' as i32 + 26)).abs();
        let min = a.min(b);
        if min <= n {
            answer[i] = 'a';
            n -= min;
        } else {
            answer[i] = (c as u8 - n as u8) as char;
            n = 0;
        }
    }
    answer.into_iter().collect()
}

fn main() {
    println!("{}", get_smallest_string("zbbz".to_string(), 3)); // "aaaz"
    println!("{}", get_smallest_string("xaxcd".to_string(), 4)); // "aawcd"
    println!("{}", get_smallest_string("lol".to_string(), 0)); // "lol"
}
