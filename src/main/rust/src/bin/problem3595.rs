use std::collections::HashMap;

// https://leetcode.com/problems/once-twice
pub fn once_twice(nums: Vec<i32>) -> Vec<i32> {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in nums.iter() {
        *map.entry(*num).or_insert(0) += 1;
    }
    let mut answer = vec![0; 2];
    for (num, count) in map.iter() {
        if *count == 1 {
            answer[0] = *num;
        } else if *count == 2 {
            answer[1] = *num;
        }
    }
    answer
}

fn main() {
    println!("{:?}", once_twice(vec![2, 2, 3, 2, 5, 5, 5, 7, 7])); // [3,7]
    println!("{:?}", once_twice(vec![4, 4, 6, 4, 9, 9, 9, 6, 8])); // [8,6]
}
