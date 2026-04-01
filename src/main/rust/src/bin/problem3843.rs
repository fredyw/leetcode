use std::collections::HashMap;

// https://leetcode.com/problems/first-element-with-unique-frequency/description/
pub fn first_unique_freq(nums: Vec<i32>) -> i32 {
    let mut freqs: HashMap<i32, i32> = HashMap::new();
    for num in &nums {
        *freqs.entry(*num).or_insert(0) += 1;
    }
    let mut unique_counts: HashMap<i32, bool> = HashMap::new();
    for (_, count) in &freqs {
        if unique_counts.contains_key(count) {
            unique_counts.insert(*count, false);
        } else {
            unique_counts.insert(*count, true);
        }
    }
    for &num in &nums {
        let count = freqs.get(&num).unwrap();
        if let Some(unique) = unique_counts.get(count) {
            if *unique {
                return num;
            }
        }
    }
    -1
}

fn main() {
    println!("{}", first_unique_freq(vec![20, 10, 30, 30])); // 30
    println!("{}", first_unique_freq(vec![20, 20, 10, 30, 30, 30])); // 20
    println!("{}", first_unique_freq(vec![10, 10, 20, 20])); // -1
}
