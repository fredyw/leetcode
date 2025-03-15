use std::collections::HashSet;

// https://leetcode.com/problems/unique-3-digit-even-numbers/description/
pub fn total_numbers(digits: Vec<i32>) -> i32 {
    let mut set: HashSet<i32> = HashSet::new();
    for i in 0..digits.len() {
        if digits[i] == 0 {
            continue;
        }
        for j in 0..digits.len() {
            if i == j {
                continue;
            }
            for k in 0..digits.len() {
                if i == k || k == j {
                    continue;
                }
                let n = format!("{}{}{}", digits[i], digits[j], digits[k])
                    .parse::<i32>()
                    .unwrap();
                if n % 2 == 0 {
                    set.insert(n);
                }
            }
        }
    }
    set.len() as i32
}

fn main() {
    println!("{}", total_numbers(vec![1, 2, 3, 4])); // 12
    println!("{}", total_numbers(vec![0, 2, 2])); // 2
    println!("{}", total_numbers(vec![6, 6, 6])); // 1
    println!("{}", total_numbers(vec![1, 3, 5])); // 0
}
