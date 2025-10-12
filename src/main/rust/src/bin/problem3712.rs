use std::collections::HashMap;

// https://leetcode.com/problems/sum-of-elements-with-frequency-divisible-by-k/
pub fn sum_divisible_by_k(nums: Vec<i32>, k: i32) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in nums {
        *map.entry(num).or_insert(0) += 1;
    }
    map.iter()
        .filter(|(_, c)| *c % k == 0)
        .map(|(n, c)| *n * *c)
        .sum()
}

fn main() {
    println!("{}", sum_divisible_by_k(vec![1, 2, 2, 3, 3, 3, 3, 4], 2)); // 16
    println!("{}", sum_divisible_by_k(vec![1, 2, 3, 4, 5], 2)); // 0
    println!("{}", sum_divisible_by_k(vec![4, 4, 4, 1, 2, 3], 3)); // 12
}
