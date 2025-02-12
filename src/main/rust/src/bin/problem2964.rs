use std::collections::HashMap;

// https://leetcode.com/problems/number-of-divisible-triplet-sums/
pub fn divisible_triplet_count(nums: Vec<i32>, d: i32) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for i in 0..nums.len() {
        *map.entry(nums[i] % d).or_insert(0) += 1;
    }
    println!("{:?}", map);
    for i in 0..nums.len() {
        for j in i + 1..nums.len() {
            // (a + b) % d = 0
            // b = (d - (a % d)) % d
            let a = nums[i] + nums[j];
            let b = (d - (a % d)) % d;
            if let Some(count) = map.get(&b) {
                println!("b: {b}, count: {count}");
            }
        }
    }
    0
}

fn main() {
    println!("{}", divisible_triplet_count(vec![3, 3, 4, 7, 8], 5)); // 3
                                                                     // println!("{}", divisible_triplet_count(vec![3, 3, 3, 3], 3)); // 4
                                                                     // println!("{}", divisible_triplet_count(vec![3, 3, 3, 3], 6)); // 0
}
