use std::collections::HashMap;

// https://leetcode.com/problems/unique-middle-element/description/
pub fn is_middle_element_unique(nums: Vec<i32>) -> bool {
    let mut uniques: HashMap<i32, bool> = HashMap::new();
    for num in &nums {
        uniques
            .entry(*num)
            .and_modify(|e| *e = false)
            .or_insert(true);
    }
    let mid = nums[(nums.len() - 1) / 2];
    *uniques.get(&mid).unwrap()
}

fn main() {
    println!("{}", is_middle_element_unique(vec![1, 2, 3])); // true
    println!("{}", is_middle_element_unique(vec![1, 2, 2])); // false
}
