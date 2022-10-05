use std::collections::HashMap;

// https://leetcode.com/problems/bitwise-xor-of-all-pairings/
pub fn xor_all_nums(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
    let mut map1: HashMap<i32, i32> = HashMap::new();
    for num1 in nums1.into_iter() {
        *map1.entry(num1).or_insert(0) += 1;
    }
    let mut map2: HashMap<i32, i32> = HashMap::new();
    for num2 in nums2.into_iter() {
        *map2.entry(num2).or_insert(0) += 1;
    }
    let nums1: Vec<i32> = map1
        .iter()
        .filter(|(_, c)| *c % 2 != 0)
        .map(|(n, _)| *n)
        .collect();
    let nums2: Vec<i32> = map2
        .iter()
        .filter(|(_, c)| *c % 2 != 0)
        .map(|(n, _)| *n)
        .collect();
    let mut answer = 0;
    for num1 in nums1.iter() {
        for num2 in nums2.iter() {
            answer ^= num1 ^ num2;
        }
    }
    answer
}

fn main() {
    println!("{}", xor_all_nums(vec![2, 1, 3], vec![10, 2, 5, 0])); // 13
    println!("{}", xor_all_nums(vec![1, 2], vec![3, 4])); // 0
    println!(
        "{}",
        xor_all_nums(vec![8, 6, 29, 2, 26, 16, 15, 29], vec![24, 12, 12])
    ); // 9
    println!("{}", xor_all_nums(vec![8, 6, 2, 26, 16, 15], vec![24])); // 9
}
