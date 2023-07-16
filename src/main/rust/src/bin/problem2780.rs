use std::collections::HashMap;

// https://leetcode.com/problems/minimum-index-of-a-valid-split/
pub fn minimum_index(nums: Vec<i32>) -> i32 {
    let mut dominant_num = 0;
    let mut dominant_count = 0;
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in nums.iter() {
        *map.entry(*num).or_insert(0) += 1;
        let count = map.get(&num).unwrap();
        if *count > dominant_count {
            dominant_num = *num;
            dominant_count = *count;
        }
    }
    let mut current_count = 0;
    for (i, num) in nums.iter().enumerate() {
        if *num == dominant_num {
            current_count += 1;
            let left_length: i32 = i as i32 + 1;
            let right_length: i32 = nums.len() as i32 - i as i32 - 1;
            if current_count * 2 > left_length
                && (dominant_count - current_count) * 2 > right_length
            {
                return i as i32;
            }
        }
    }
    -1
}

fn main() {
    println!("{}", minimum_index(vec![1, 2, 2, 2])); // 2
    println!("{}", minimum_index(vec![2, 1, 3, 1, 1, 1, 7, 1, 2, 1])); // 4
    println!("{}", minimum_index(vec![3, 3, 3, 3, 7, 2, 2])); // -1
}
