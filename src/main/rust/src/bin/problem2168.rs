use std::collections::HashSet;

// https://leetcode.com/problems/unique-substrings-with-equal-digit-frequency/description/
pub fn equal_digit_frequency(s: String) -> i32 {
    let mut set: HashSet<&str> = HashSet::new();
    for i in 0..s.len() {
        'outer: for j in i + 1..=s.len() {
            let sub = &s[i..j];
            if set.contains(sub) {
                continue;
            }
            let mut digits = vec![0; 10];
            for b in sub.as_bytes() {
                digits[*b as usize - '0' as usize] += 1;
            }
            let mut count = 0;
            for i in 0..10 {
                if digits[i] != 0 {
                    if count == 0 {
                        count = digits[i];
                    } else if count != digits[i] {
                        continue 'outer;
                    }
                }
            }
            set.insert(sub);
        }
    }
    set.len() as i32
}

fn main() {
    println!("{}", equal_digit_frequency("1212".to_string())); // 5
    println!("{}", equal_digit_frequency("12321".to_string())); // 9
}
