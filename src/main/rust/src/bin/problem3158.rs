use std::collections::HashMap;

// https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/description/
pub fn duplicate_numbers_xor(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in nums {
        *map.entry(num).or_insert(0) += 1
    }
    for (num, count) in map.iter() {
        if *count == 2 {
            answer ^= num;
        }
    }
    answer
}

fn main() {
    println!("{}", duplicate_numbers_xor(vec![1, 2, 1, 3])); // 1
    println!("{}", duplicate_numbers_xor(vec![1, 2, 3])); // 0
    println!("{}", duplicate_numbers_xor(vec![1, 2, 2, 1])); // 3
}
