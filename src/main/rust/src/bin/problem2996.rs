use std::collections::HashSet;

// https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/
pub fn missing_integer(nums: Vec<i32>) -> i32 {
    fn next_greater(mut n: i32, set: &HashSet<i32>) -> i32 {
        while set.contains(&n) {
            n += 1;
        }
        n
    }

    let mut set: HashSet<i32> = HashSet::new();
    for &num in nums.iter() {
        set.insert(num);
    }
    let mut sum = 0;
    for i in 0..nums.len() {
        if i + 1 < nums.len() && nums[i] + 1 == nums[i + 1] {
            sum += nums[i];
        } else {
            sum += nums[i];
            break;
        }
    }
    next_greater(sum, &set)
}

fn main() {
    println!("{}", missing_integer(vec![1, 2, 3, 2, 5])); // 6
    println!("{}", missing_integer(vec![3, 4, 5, 1, 12, 14, 13])); // 15
    println!("{}", missing_integer(vec![1, 2, 3, 9, 10, 11])); // 6
    println!("{}", missing_integer(vec![1, 2, 3, 6, 9, 10, 11])); // 7
    println!("{}", missing_integer(vec![1, 9, 10])); // 2
    println!("{}", missing_integer(vec![5, 10, 1])); // 6
    println!("{}", missing_integer(vec![1, 5, 10])); // 2
    println!("{}", missing_integer(vec![1, 2, 3])); // 6
}
