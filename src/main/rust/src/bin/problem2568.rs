use std::collections::HashSet;

// https://leetcode.com/problems/minimum-impossible-or/
pub fn min_impossible_or(nums: Vec<i32>) -> i32 {
    let nums: HashSet<i32> = nums.into_iter().collect();
    let mut answer: i32 = 0;
    loop {
        let power_of_two: i32 = (2 as i32).pow(answer as u32);
        if !nums.contains(&power_of_two) {
            return power_of_two;
        }
        answer += 1;
    }
}

fn main() {
    println!("{}", min_impossible_or(vec![2, 1])); // 4
    println!("{}", min_impossible_or(vec![5, 3, 2])); // 1
    println!("{}", min_impossible_or(vec![5, 3, 2, 1])); // 4
    println!("{}", min_impossible_or(vec![1, 2, 3, 4, 5])); // 8
}
