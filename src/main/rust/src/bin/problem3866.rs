use std::collections::HashMap;

// https://leetcode.com/problems/first-unique-even-element/
pub fn first_unique_even(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in &nums {
        *map.entry(*num).or_insert(0) += 1;
    }
    for num in &nums {
        if num % 2 == 0 {
            if let Some(count) = map.get(num) {
                if *count == 1 {
                    return *num;
                }
            }
        }
    }
    -1
}

fn main() {
    println!("{}", first_unique_even(vec![3, 4, 2, 5, 4, 6])); // 2
    println!("{}", first_unique_even(vec![4, 4])); // -1
}
