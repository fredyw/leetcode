use std::collections::HashMap;

// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/
pub fn max_subarray_length(nums: Vec<i32>, k: i32) -> i32 {
    let mut answer = 0;
    let mut map: HashMap<i32, i32> = HashMap::new();
    let mut i = 0;
    let mut j = 0;
    while j < nums.len() {
        let count = map.get(&nums[j]).unwrap_or(&0);
        if count + 1 <= k {
            *map.entry(nums[j]).or_insert(0) += 1;
            j += 1;
        } else {
            while i < j {
                *map.entry(nums[i]).or_insert(0) -= 1;
                i += 1;
                if nums[i - 1] == nums[j] {
                    break;
                }
            }
        }
        answer = answer.max(j as i32 - i as i32);
    }
    answer
}

fn main() {
    println!("{}", max_subarray_length(vec![1, 2, 3, 1, 2, 3, 1, 2], 2)); // 6
    println!("{}", max_subarray_length(vec![1, 2, 1, 2, 1, 2, 1, 2], 1)); // 2
    println!("{}", max_subarray_length(vec![5, 5, 5, 5, 5, 5, 5], 4)); // 4
}
