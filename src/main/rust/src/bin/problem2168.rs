use std::collections::HashSet;

// https://leetcode.com/problems/unique-substrings-with-equal-digit-frequency/description/
pub fn equal_digit_frequency(s: String) -> i32 {
    let mut set: HashSet<&str> = HashSet::new();
    for i in 0..s.len() {
        let mut counts: Vec<i32> = vec![0; 10];
        let mut num_unique = 0;
        let mut max_count = 0;
        let mut total_count = 0;
        for j in i + 1..=s.len() {
            let sub = &s[i..j];
            let digit = *(&s[j - 1..j].as_bytes()[0]) as usize - '0' as usize;
            if counts[digit] == 0 {
                num_unique += 1;
            }
            counts[digit] += 1;
            max_count = max_count.max(counts[digit]);
            total_count += 1;
            if set.contains(sub) {
                continue;
            }
            if num_unique * max_count == total_count {
                set.insert(sub);
            }
        }
    }
    set.len() as i32
}

fn main() {
    println!("{}", equal_digit_frequency("1212".to_string())); // 5
    println!("{}", equal_digit_frequency("12321".to_string())); // 9
}
