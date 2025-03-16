use std::collections::HashSet;

// https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/
pub fn max_sum(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut set: HashSet<i32> = HashSet::new();
    let mut all_negative = true;
    let mut max = i32::MIN;
    for num in nums.iter() {
        if *num > 0 {
            all_negative = false;
        }
        max = max.max(*num);
        if set.contains(num) {
            continue;
        }
        if answer + num > answer {
            answer += num;
        }
        set.insert(*num);
    }
    if all_negative {
        max
    } else {
        answer
    }
}

fn main() {
    println!("{}", max_sum(vec![1, 2, 3, 4, 5])); // 15
    println!("{}", max_sum(vec![1, 1, 0, 1, 1])); // 1
    println!("{}", max_sum(vec![1, 2, -1, -2, 1, 0, -1])); // 3
    println!("{}", max_sum(vec![-3, -2, -3, -1])); // -1
}
