use std::collections::HashMap;

// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/
pub fn max_sub_array_len(nums: Vec<i32>, k: i32) -> i32 {
    let mut map: HashMap<i32, usize> = HashMap::new();
    let mut prefix_sums: Vec<i32> = vec![0; nums.len()];
    for (i, num) in nums.iter().enumerate() {
        if i == 0 {
            prefix_sums[i] = *num;
        } else {
            prefix_sums[i] = prefix_sums[i - 1] + num;
        }
        map.insert(prefix_sums[i], i);
    }
    let mut answer = 0;
    for i in 0..nums.len() {
        if i == 0 {
            if let Some(index) = map.get(&k) {
                answer = answer.max(*index as i32 + 1);
            }
        } else {
            let x = prefix_sums[i] + (k - (prefix_sums[i] - prefix_sums[i - 1]));
            if let Some(index) = map.get(&x) {
                answer = answer.max(*index as i32 - i as i32 + 1);
            }
        }
    }
    answer
}

fn main() {
    println!("{}", max_sub_array_len(vec![1, -1, 5, -2, 3], 3)); // 4
    println!("{}", max_sub_array_len(vec![-2, -1, 2, 1], 1)); // 2
    println!("{}", max_sub_array_len(vec![3, 1, -1, 5, -2, 3], 3)); // 4
}
