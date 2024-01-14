use std::collections::HashMap;

// https://leetcode.com/problems/count-elements-with-maximum-frequency/
pub fn max_frequency_elements(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in nums.into_iter() {
        *map.entry(num).or_insert(0) += 1;
    }
    let mut answer = 0;
    let mut max = 0;
    for &count in map.values() {
        if count > max {
            max = count;
            answer = count;
        } else if count == max {
            answer += count;
        }
    }
    answer
}

fn main() {
    println!("{}", max_frequency_elements(vec![1, 2, 2, 3, 1, 4])); // 4
    println!("{}", max_frequency_elements(vec![1, 2, 3, 4, 5])); // 5
}
