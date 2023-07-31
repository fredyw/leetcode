use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/count-complete-subarrays-in-an-array/
pub fn count_complete_subarrays(nums: Vec<i32>) -> i32 {
    let mut set: HashSet<i32> = HashSet::new();
    for num in nums.iter() {
        set.insert(*num);
    }
    let mut answer = 0;
    let mut map: HashMap<i32, i32> = HashMap::new();
    let mut i = 0;
    let mut j = 0;
    while i < nums.len() && j < nums.len() {
        *map.entry(nums[j]).or_insert(0) += 1;
        if map.len() == set.len() {
            answer += nums.len() - j;
            let count = map.entry(nums[i]).or_insert(0);
            *count -= 1;
            if *count == 0 {
                map.remove(&nums[i]);
            }
            i += 1;
        } else {
            j += 1;
        }
        if j < i {
            j += 1;
        }
    }
    answer as i32
}

fn main() {
    // println!("{}", count_complete_subarrays(vec![1, 3, 1, 2, 2])); // 4
    // println!("{}", count_complete_subarrays(vec![5, 5, 5, 5])); // 10
    // println!(
    //     "{}",
    //     count_complete_subarrays(vec![459, 459, 962, 1579, 1435, 756, 1872, 1597])
    // ); // 2
    println!("{}", count_complete_subarrays(vec![1454, 1789, 1454])); // 3
}
