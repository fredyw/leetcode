use std::collections::HashMap;

// https://leetcode.com/problems/distinct-numbers-in-each-subarray/description/
pub fn distinct_numbers(nums: Vec<i32>, k: i32) -> Vec<i32> {
    let mut map: HashMap<i32, i32> = HashMap::new();
    let mut answer = vec![];
    let mut i = 0;
    while i < k {
        *map.entry(nums[i as usize]).or_insert(0) += 1;
        i += 1;
    }
    let mut j = 0;
    answer.push(map.len() as i32);
    while i < nums.len() as i32 {
        if let Some(count) = map.get_mut(&nums[j]) {
            if *count - 1 == 0 {
                map.remove(&nums[j]);
            } else {
                *count -= 1;
            }
        }
        *map.entry(nums[i as usize]).or_insert(0) += 1;
        answer.push(map.len() as i32);
        i += 1;
        j += 1;
    }
    answer
}

fn main() {
    println!("{:?}", distinct_numbers(vec![1, 2, 3, 2, 2, 1, 3], 3)); // [3,2,2,2,3]
    println!("{:?}", distinct_numbers(vec![1, 1, 1, 1, 2, 3, 4], 4)); // [1,2,3,4]
}
