use std::collections::HashMap;

// https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/
pub fn find_x_sum(nums: Vec<i32>, k: i32, x: i32) -> Vec<i32> {
    let mut answer = vec![];
    let mut map: HashMap<i32, i32> = HashMap::new();
    let mut length = 0;
    for i in 0..nums.len() {
        length += 1;
        if length > k {
            let count = map.entry(nums[i] - nums[i - (k as usize - 1)]).or_insert(0);
            if *count - 1 == 0 {
                map.remove(&(nums[i] - nums[i - (k as usize - 1)]));
            } else {
                *count -= 1;
            }
            length -= 1;
        }
        *map.entry(nums[i]).or_insert(0) += 1;
        if length == k {
            let mut v: Vec<(i32, i32)> = map.iter().map(|(n, c)| (*c, *n)).collect();
            v.sort_by(|a, b| b.cmp(&a));
            let mut sum = 0;
            let mut j = 0;
            while j < v.len() && j < x as usize {
                sum += v[j].0 * v[j].1;
                j += 1;
            }
            answer.push(sum);
        }
    }
    answer
}

fn main() {
    // println!("{:?}", find_x_sum(vec![1, 1, 2, 2, 3, 4, 2, 3], 6, 2)); // [6,10,12]
    println!("{:?}", find_x_sum(vec![3, 8, 7, 8, 7, 5], 2, 2)); // [11,15,15,15,12]
}
