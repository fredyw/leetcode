use std::collections::HashMap;

// https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/
pub fn min_number(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    let mut min1 = i32::MAX;
    for num in nums1.into_iter() {
        min1 = min1.min(num);
        *map.entry(num).or_insert(0) += 1;
    }
    let mut min2 = i32::MAX;
    for num in nums2.into_iter() {
        min2 = min2.min(num);
        *map.entry(num).or_insert(0) += 1;
    }
    let mut answer = i32::MAX;
    for (num, count) in map.into_iter() {
        if count > 1 {
            answer = answer.min(num);
        }
    }
    if min1 > min2 {
        answer = answer.min(format!("{}{}", min2, min1).parse().unwrap());
    } else {
        answer = answer.min(format!("{}{}", min1, min2).parse().unwrap());
    }
    answer
}

fn main() {
    println!("{}", min_number(vec![4, 1, 3], vec![5, 7])); // 15
    println!("{}", min_number(vec![5, 7], vec![4, 1, 3])); // 15
    println!("{}", min_number(vec![3, 5, 2, 6], vec![3, 1, 7])); // 3
}
