use std::collections::HashMap;

// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/
pub fn min_operations(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for &num in nums.iter() {
        *map.entry(num).or_insert(0) += 1;
    }
    let mut answer = 0;
    for (_, &value) in map.iter() {
        if value == 1 {
            return -1;
        }
        if value % 3 == 0 {
            answer += value / 3;
        } else if (value % 3) % 2 == 0 {
            answer += value / 3;
            answer += (value % 3) / 2;
        } else if ((value % 3) + 3) % 2 == 0 {
            answer += (value / 3) - 1;
            answer += ((value % 3) + 3) / 2;
        } else if value % 2 == 0 {
            answer += value / 2;
        } else {
            return -1;
        }
    }
    answer
}

fn main() {
    println!("{}", min_operations(vec![2, 3, 3, 2, 2, 4, 2, 3, 4])); // 4
    println!("{}", min_operations(vec![2, 1, 2, 2, 3, 3])); // -1
    println!("{}", min_operations(vec![2, 2, 2, 2, 2, 2, 2, 2])); // 3
    println!("{}", min_operations(vec![2, 2, 2, 2, 2, 2, 2, 2, 2, 2])); // 4
    println!(
        "{}",
        min_operations(vec![
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        ])
    ); // 7
}
