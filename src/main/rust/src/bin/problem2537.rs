use std::collections::HashMap;

// https://leetcode.com/problems/count-the-number-of-good-subarrays/
pub fn count_good(nums: Vec<i32>, k: i32) -> i64 {
    fn combination(n: i32) -> i32 {
        (n * (n - 1)) / 2
    }

    let mut answer = 0;
    for i in 0..nums.len() {
        let mut map: HashMap<i32, i32> = HashMap::new();
        for j in i..nums.len() {
            *map.entry(nums[j]).or_insert(0) += 1;
            let mut num_pairs = 0;
            for (_, count) in map.iter() {
                if *count > 1 {
                    num_pairs += combination(*count);
                }
            }
            if num_pairs >= k {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", count_good(vec![1, 1, 1, 1, 1], 10)); // 1
    println!("{}", count_good(vec![3, 1, 4, 3, 2, 2, 4], 2)); // 4
    println!("{}", count_good(vec![1, 1, 2, 3, 4], 10)); // 0
    println!("{}", count_good(vec![1, 2, 2, 2], 10)); // 0
    println!("{}", count_good(vec![1, 2, 2, 2], 3)); // 2
}
