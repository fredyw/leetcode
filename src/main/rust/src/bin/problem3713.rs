// https://leetcode.com/problems/longest-balanced-substring-i/description/
pub fn longest_balanced(s: String) -> i32 {
    fn is_balanced(counts: &Vec<i32>) -> bool {
        let mut c = 0;
        for count in counts {
            if *count != 0 {
                if c == 0 {
                    c = *count;
                } else {
                    if c != *count {
                        return false;
                    }
                }
            }
        }
        true
    }

    let bytes = s.as_bytes();
    let mut answer = 0;
    for i in 0..bytes.len() {
        let mut counts: Vec<i32> = vec![0; 26];
        for j in i..bytes.len() {
            counts[bytes[j] as usize - b'a' as usize] += 1;
            if is_balanced(&counts) {
                answer = answer.max(j as i32 - i as i32 + 1);
            }
        }
    }
    answer
}

fn main() {
    println!("{}", longest_balanced("abbac".to_string())); // 4
    println!("{}", longest_balanced("zzabccy".to_string())); // 4
    println!("{}", longest_balanced("aba".to_string())); // 2
}
