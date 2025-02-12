use std::collections::HashMap;

// https://leetcode.com/problems/number-of-divisible-triplet-sums/
pub fn divisible_triplet_count(mut nums: Vec<i32>, d: i32) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for i in 0..nums.len() {
        nums[i] = nums[i] % d;
        *map.entry(nums[i]).or_insert(0) += 1;
    }
    let mut answer = 0;
    let mut map1: HashMap<i32, i32> = HashMap::new();
    for i in 0..nums.len() {
        *map1.entry(nums[i]).or_insert(0) += 1;
        let mut map2: HashMap<i32, i32> = HashMap::new();
        for j in i + 1..nums.len() - 1 {
            *map2.entry(nums[j]).or_insert(0) += 1;
            // (a + b) % d = 0
            // b = (d - (a % d)) % d
            let a = nums[i] + nums[j];
            let b = (d - (a % d)) % d;
            if let Some(count) = map.get(&b) {
                answer += *count;
                // Remove duplicates.
                answer -= map1.get(&b).unwrap_or(&0);
                answer -= map2.get(&b).unwrap_or(&0);
            }
        }
    }
    answer
}

fn main() {
    println!("{}", divisible_triplet_count(vec![3, 3, 4, 7, 8], 5)); // 3
    println!("{}", divisible_triplet_count(vec![3, 3, 3, 3], 3)); // 4
    println!("{}", divisible_triplet_count(vec![3, 3, 3, 3], 6)); // 0
}
