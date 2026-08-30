use std::collections::HashMap;

// https://leetcode.com/problems/count-integers-appearing-in-a-single-block/description/
pub fn count_special_integers(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    let mut i = 0;
    let mut dupe = false;
    while i < nums.len() - 1 {
        if !dupe {
            *map.entry(nums[i]).or_insert(0) += 1;
        }
        dupe = nums[i] == nums[i + 1];
        i += 1;
    }
    if !dupe {
        *map.entry(nums[i]).or_insert(0) += 1;
    }
    map.into_iter().filter(|(_, c)| *c == 1).count() as i32
}

fn main() {
    println!("{}", count_special_integers(vec![1, 2, 2, 1])); // 1
    println!("{}", count_special_integers(vec![3, 3, 1, 2, 2, 1])); // 2
    println!("{}", count_special_integers(vec![3, 3, 1, 2, 2, 1, 3, 3])); // 1
    println!("{}", count_special_integers(vec![1, 2, 3])); // 3
    println!("{}", count_special_integers(vec![1])); // 1
}
