use std::collections::HashMap;

// https://leetcode.com/problems/smallest-pair-with-different-frequencies/
pub fn min_distinct_freq_pair(mut nums: Vec<i32>) -> Vec<i32> {
    nums.sort_unstable();
    let mut map: HashMap<i32, i32> = HashMap::new();
    for i in 0..nums.len() {
        *map.entry(nums[i]).or_insert(0) += 1;
    }
    let first_count = map.get(&nums[0]).unwrap();
    for i in 0..nums.len() {
        let count = map.get(&nums[i]).unwrap();
        if first_count != count {
            return vec![nums[0], nums[i]];
        }
    }
    vec![-1, -1]
}

fn main() {
    println!("{:?}", min_distinct_freq_pair(vec![1, 1, 2, 2, 3, 4])); // [1,3]
    println!("{:?}", min_distinct_freq_pair(vec![1, 5])); // [-1,-1]
    println!("{:?}", min_distinct_freq_pair(vec![7])); // [-1,-1]
    println!("{:?}", min_distinct_freq_pair(vec![1, 5, 6, 6])); // [1, 6]
}
