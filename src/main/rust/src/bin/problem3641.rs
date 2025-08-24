use std::collections::HashMap;

// https://leetcode.com/problems/longest-semi-repeating-subarray/description/
pub fn longest_subarray(nums: Vec<i32>, k: i32) -> i32 {
    let mut answer = 0;
    let mut map: HashMap<i32, i32> = HashMap::new();
    let mut count = 0;
    let mut j = 0;
    for i in 0..nums.len() {
        let c = map.entry(nums[i]).or_insert(0);
        *c += 1;
        if *c > 1 {
            count += 1;
        }
        if count > k {
            while j < i && count > k {
                let c = map.entry(nums[j]).or_insert(0);
                *c -= 1;
                if *c == 0 {
                    map.remove(&nums[j]);
                } else if *c == 1 {
                    count -= 1;
                }
                j += 1;
            }
        }
        answer = answer.max(i - j + 1);
    }
    answer as i32
}

fn main() {
    // println!("{}", longest_subarray(vec![1, 2, 3, 1, 2, 3, 4], 2)); // 6
    // println!("{}", longest_subarray(vec![1, 1, 1, 1, 1], 4)); // 5
    // println!("{}", longest_subarray(vec![1, 1, 1, 1, 1], 0)); // 1
    println!(
        "{}",
        longest_subarray(vec![1, 2, 1, 1, 1, 1, 1, 1, 3, 1, 2, 3, 4], 2)
    ); // 11
       // println!("{}", longest_subarray(vec![1, 2, 3, 4, 5], 0)); // 5
}
