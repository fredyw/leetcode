use std::collections::HashSet;

// https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/
pub fn max_count(banned: Vec<i32>, n: i32, max_sum: i32) -> i32 {
    let mut answer = 0;
    let mut sum = 0;
    let set: HashSet<i32> = banned.iter().map(|e| *e).collect();
    for i in 1..=n {
        if set.contains(&i) {
            continue;
        }
        sum += i;
        if sum > max_sum {
            break;
        }
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", max_count(vec![1, 6, 5], 5, 6)); // 2
    println!("{}", max_count(vec![1, 2, 3, 4, 5, 6, 7], 8, 1)); // 0
    println!("{}", max_count(vec![11], 7, 50)); // 7
}
