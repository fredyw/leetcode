use std::collections::HashMap;

// https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/
pub fn minimum_operations(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in nums.iter() {
        *map.entry(*num).or_insert(0) += 1;
    }
    let mut map: HashMap<i32, i32> = map
        .into_iter()
        .map(|(num, count)| (num, count - 1))
        .filter(|(_, count)| *count > 0)
        .collect();
    let mut answer = 0;
    let mut i = 0;
    while i < nums.len() && !map.is_empty() {
        let mut j = i;
        while j < nums.len() && j < i + 3 {
            if let Some(count) = map.get_mut(&nums[j]) {
                *count -= 1;
                if *count == 0 {
                    map.remove(&nums[j]);
                }
            }
            j += 1;
        }
        answer += 1;
        i += 3;
    }
    answer
}

fn main() {
    println!("{}", minimum_operations(vec![1, 2, 3, 4, 2, 3, 3, 5, 7])); // 2
    println!("{}", minimum_operations(vec![4, 5, 6, 4, 4])); // 2
    println!("{}", minimum_operations(vec![6, 7, 8, 9])); // 0
}
