use std::collections::HashMap;

// https://leetcode.com/problems/maximum-number-of-pairs-in-array/
pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![0; 2];
    let mut map: HashMap<i32, i32> = HashMap::new();
    for i in nums {
        if !map.contains_key(&i) {
            map.insert(i, 1);
        } else {
            map.insert(i, map.get(&i).unwrap() + 1);
        }
    }
    let mut num_pairs = 0;
    let mut num_leftover = 0;
    for (_, count) in map.iter() {
        num_pairs += count / 2;
        num_leftover += count % 2;
    }
    answer[0] = num_pairs;
    answer[1] = num_leftover;
    answer
}

fn main() {
    println!("{:?}", number_of_pairs(vec![1, 3, 2, 1, 3, 2, 2])); // [3,1]
    println!("{:?}", number_of_pairs(vec![1, 1])); // [1,0]
    println!("{:?}", number_of_pairs(vec![0])); // [0,1]
}
