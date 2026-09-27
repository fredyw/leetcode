use std::collections::BTreeMap;

// https://leetcode.com/problems/rearrange-array-by-removing-distinct-values/description/
pub fn rearrange_array(nums: Vec<i32>) -> Vec<i32> {
    let mut map: BTreeMap<i32, i32> = BTreeMap::new();
    for num in nums {
        *map.entry(num).or_insert(0) += 1;
    }
    let mut answer: Vec<i32> = Vec::new();
    while !map.is_empty() {
        map.retain(|&num, count| {
            answer.push(num);
            *count -= 1;
            *count > 0
        });
    }
    answer
}

fn main() {
    println!("{:?}", rearrange_array(vec![3, 1, 3, 2, 1, 3])); // [1,2,3,1,3,3]
    println!("{:?}", rearrange_array(vec![7, 7, 4, 4, 4])); // [4,7,4,7,4]
}
