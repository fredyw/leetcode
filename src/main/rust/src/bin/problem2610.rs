use std::collections::HashMap;

// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
pub fn find_matrix(nums: Vec<i32>) -> Vec<Vec<i32>> {
    let mut map: HashMap<i32, Vec<i32>> = HashMap::new();
    let mut max_size = 0;
    for num in nums.into_iter() {
        map.entry(num).or_insert(vec![]).push(num);
        max_size = max_size.max(map.get(&num).unwrap().len());
    }
    let mut answer: Vec<Vec<i32>> = vec![vec![]; max_size];
    for (num, v) in map.into_iter() {
        for row in 0..v.len() {
            answer[row].push(num);
        }
    }
    answer
}

fn main() {
    println!("{:?}", find_matrix(vec![1, 3, 4, 1, 2, 3, 1])); // [[1,3,4,2],[1,3],[1]]
    println!("{:?}", find_matrix(vec![1, 2, 3, 4])); // [[4,3,2,1]]
    println!("{:?}", find_matrix(vec![2, 1, 1])); // [[1,2],[1]]
}
