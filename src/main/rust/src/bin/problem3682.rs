use std::collections::HashMap;

// https://leetcode.com/problems/minimum-index-sum-of-common-elements/description/
pub fn minimum_sum(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, usize> = HashMap::new();
    for (i, num) in nums2.iter().enumerate() {
        if !map.contains_key(&num) {
            map.insert(*num, i);
        }
    }
    let mut answer = i32::MAX;
    for (i, num) in nums1.iter().enumerate() {
        if let Some(j) = map.get(num) {
            answer = answer.min(i as i32 + *j as i32);
        }
    }
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    println!("{}", minimum_sum(vec![3, 2, 1], vec![1, 3, 1])); // 1
    println!("{}", minimum_sum(vec![5, 1, 2], vec![2, 1, 3])); // 2
    println!("{}", minimum_sum(vec![6, 4], vec![7, 8])); // -1
}
