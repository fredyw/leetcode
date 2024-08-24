use std::collections::HashMap;

// https://leetcode.com/problems/subarray-sum-equals-k/description/
pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
    let mut answer = 0;
    let mut map: HashMap<i32, i32> = HashMap::new();
    map.insert(0, 1);
    let mut sum = 0;
    for num in nums.iter() {
        sum += *num;
        if let Some(n) = map.get(&(sum - k)) {
            answer += *n;
        }
        *map.entry(sum).or_insert(0) += 1;
    }
    answer
}

fn main() {
    println!("{}", subarray_sum(vec![1, 1, 1], 2)); // 2
    println!("{}", subarray_sum(vec![1, 2, 3], 3)); // 2
    println!("{}", subarray_sum(vec![1, 2, 3, 1, 2], 3)); // 3
}
