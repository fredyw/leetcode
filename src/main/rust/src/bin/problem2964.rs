use std::collections::HashMap;

// https://leetcode.com/problems/number-of-divisible-triplet-sums/
pub fn divisible_triplet_count(nums: Vec<i32>, d: i32) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    let mut answer = 0;
    for i in 0..nums.len() {
        // (a + b) % d = 0
        // b = (d - (a % d)) % d
        let a = nums[i];
        let b = (d - (a % d)) % d;
        answer += map.get(&b).unwrap_or(&0);
        for j in 0..i {
            *map.entry((nums[i] + nums[j]) % d).or_insert(0) += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", divisible_triplet_count(vec![3, 3, 4, 7, 8], 5)); // 3
    println!("{}", divisible_triplet_count(vec![3, 3, 3, 3], 3)); // 4
    println!("{}", divisible_triplet_count(vec![3, 3, 3, 3], 6)); // 0
}
