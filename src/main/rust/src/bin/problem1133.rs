use std::collections::HashMap;

// https://leetcode.com/problems/largest-unique-number/description/
pub fn largest_unique_number(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in nums.iter() {
        *map.entry(*num).or_insert(0) += 1;
    }
    let mut answer = -1;
    for num in nums.iter() {
        let count = map.get(num).unwrap();
        if *count == 1 {
            answer = answer.max(*num);
        }
    }
    answer
}

fn main() {
    println!("{}", largest_unique_number(vec![5, 7, 3, 9, 4, 9, 8, 3, 1])); // 8
    println!("{}", largest_unique_number(vec![9, 9, 8, 8])); // -1
}
