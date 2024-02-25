use std::collections::HashMap;

// https://leetcode.com/problems/split-the-array/description/
pub fn is_possible_to_split(nums: Vec<i32>) -> bool {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in nums {
        *map.entry(num).or_insert(0) += 1;
    }
    for (_, count) in map.into_iter() {
        if count > 2 {
            return false;
        }
    }
    true
}

fn main() {
    println!("{}", is_possible_to_split(vec![1, 1, 2, 2, 3, 4])); // true
    println!("{}", is_possible_to_split(vec![1, 1, 1, 1])); // false
}
