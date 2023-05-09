use std::collections::HashMap;

// https://leetcode.com/problems/count-the-number-of-beautiful-subarrays/
pub fn beautiful_subarrays(nums: Vec<i32>) -> i64 {
    let mut prefix: Vec<i32> = vec![0; nums.len()];
    for i in 0..nums.len() {
        if i == 0 {
            prefix[i] = nums[i];
        } else {
            prefix[i] = prefix[i - 1] ^ nums[i];
        }
    }
    println!("nums  : {:?}", nums);
    println!("prefix: {:?}", prefix);
    let mut counts: HashMap<i32, i32> = HashMap::new();
    let mut answer = 0;
    for i in 0..nums.len() {
        let xor = prefix[nums.len() - 1] ^ if i == 0 { 0 } else { prefix[i - 1] };
        println!("i = {}, xor = {}", i, xor);
        *counts.entry(nums[i]).or_insert(0) += 1;
        // let mut xor = nums[i];
        // for j in i + 1..nums.len() {
        //     xor ^= nums[j];
        //     if xor == 0 {
        //         println!("i = {}, j = {}", i, j);
        //         answer += 1;
        //     }
        // }
    }
    println!("{:?}", counts);
    answer
}

fn main() {
    // println!("{}", beautiful_subarrays(vec![4, 3, 1, 2, 4])); // 2
    println!("{}", beautiful_subarrays(vec![4, 3, 1, 2, 4, 4])); // 4
                                                                 // println!("{}", beautiful_subarrays(vec![1, 10, 4])); // 0
                                                                 // println!("{}", beautiful_subarrays(vec![3, 4])); // 0
                                                                 // println!("{}", beautiful_subarrays(vec![1])); // 0
}
