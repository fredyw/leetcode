use std::collections::HashMap;

// https://leetcode.com/problems/find-the-substring-with-maximum-cost/
pub fn maximum_cost_substring(s: String, chars: String, vals: Vec<i32>) -> i32 {
    let mut map: HashMap<char, i32> = chars
        .chars()
        .enumerate()
        .map(|(i, c)| (c, vals[i]))
        .collect();
    for (i, c) in ('a'..='z').enumerate() {
        if !map.contains_key(&c) {
            map.insert(c, i as i32 + 1);
        }
    }
    let mut answer = 0;
    let s: Vec<char> = s.chars().collect();
    for i in 0..s.len() {
        let mut sum = 0;
        for j in i..s.len() {
            sum += map.get(&s[j]).unwrap();
            answer = answer.max(sum);
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        maximum_cost_substring("adaa".to_string(), "d".to_string(), vec![-1000])
    ); // 2
    println!(
        "{}",
        maximum_cost_substring("abc".to_string(), "abc".to_string(), vec![-1, -1, -1])
    ); // 0
    println!(
        "{}",
        maximum_cost_substring("adaa".to_string(), "d".to_string(), vec![1000])
    ); // 1003
}
