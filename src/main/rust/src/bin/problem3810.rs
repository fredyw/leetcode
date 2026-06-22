use std::collections::HashMap;

// https://leetcode.com/problems/minimum-operations-to-reach-target-array/description/
pub fn min_operations(nums: Vec<i32>, target: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, bool> = HashMap::new();
    for (i, num) in nums.iter().enumerate() {
        let same = map.entry(*num).or_insert(true);
        *same = *same && (*num == target[i]);
    }
    map.into_iter().filter(|(_, v)| !*v).count() as i32
}

fn main() {
    println!("{}", min_operations(vec![1, 2, 3], vec![2, 1, 3])); // 2
    println!("{}", min_operations(vec![4, 1, 4], vec![5, 1, 4])); // 1
    println!("{}", min_operations(vec![7, 3, 7], vec![5, 5, 9])); // 2
}
