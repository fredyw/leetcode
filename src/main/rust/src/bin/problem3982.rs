use std::collections::HashMap;

// https://leetcode.com/problems/sum-of-integers-with-maximum-digit-range/description/
pub fn max_digit_range(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, Vec<i32>> = HashMap::new();
    for num in &nums {
        let s = num.to_string();
        let min = s.bytes().min().unwrap() as i32 - 'a' as i32;
        let max = s.bytes().max().unwrap() as i32 - 'a' as i32;
        let diff = max - min;
        map.entry(diff).or_insert(Vec::new()).push(*num);
    }
    let max = map.iter().map(|(k, _)| *k).max().unwrap();
    map.get(&max).unwrap_or(&Vec::new()).iter().sum()
}

fn main() {
    println!("{}", max_digit_range(vec![5724, 111, 350])); // 6074
    println!("{}", max_digit_range(vec![90, 900])); // 990
}
