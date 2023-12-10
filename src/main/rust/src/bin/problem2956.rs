use std::collections::HashMap;

// https://leetcode.com/problems/find-common-elements-between-two-arrays/description/
pub fn find_intersection_values(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
    let mut map1: HashMap<i32, i32> = HashMap::new();
    for &num in nums1.iter() {
        *map1.entry(num).or_insert(0) += 1;
    }
    let mut map2: HashMap<i32, i32> = HashMap::new();
    for &num in nums2.iter() {
        *map2.entry(num).or_insert(0) += 1;
    }
    let mut answer = vec![];
    let mut count = 0;
    for num in nums1.iter() {
        if map2.contains_key(num) {
            count += 1;
        }
    }
    answer.push(count);
    let mut count = 0;
    for num in nums2.iter() {
        if map1.contains_key(num) {
            count += 1;
        }
    }
    answer.push(count);
    answer
}

fn main() {
    println!(
        "{:?}",
        find_intersection_values(vec![4, 3, 2, 3, 1], vec![2, 2, 5, 2, 3, 6])
    ); // [3,4]
    println!(
        "{:?}",
        find_intersection_values(vec![3, 4, 2, 3], vec![1, 5])
    ); // [0,0]
}
