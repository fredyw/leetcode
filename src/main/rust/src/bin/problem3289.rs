use std::collections::HashMap;

// https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/
pub fn get_sneaky_numbers(nums: Vec<i32>) -> Vec<i32> {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in nums.into_iter() {
        *map.entry(num).or_insert(0) += 1;
    }
    let mut answer = vec![];
    for (num, count) in map.iter() {
        if *count > 1 {
            answer.push(*num);
        }
    }
    answer
}

fn main() {
    println!("{:?}", get_sneaky_numbers(vec![0, 1, 1, 0])); // [0,1]
    println!("{:?}", get_sneaky_numbers(vec![0, 3, 2, 1, 3, 2])); // [2,3]
    println!(
        "{:?}",
        get_sneaky_numbers(vec![7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2])
    ); // [4,5]
}
