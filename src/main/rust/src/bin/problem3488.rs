use std::collections::HashMap;

// https://leetcode.com/problems/closest-equal-element-queries/description/
pub fn solve_queries(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
    let mut map: HashMap<i32, Vec<usize>> = HashMap::new();
    for (i, &num) in nums.iter().enumerate() {
        map.entry(num).or_insert(vec![]).push(i);
    }
    let mut answer = vec![-1; queries.len()];
    for (i, q) in queries.iter().enumerate() {
        let q = *q as usize;
        let num = nums[q];
        let indexes = map.get(&num).unwrap();
        println!("indexes: {:?}", indexes);
        let current_index = indexes.binary_search(&i).unwrap() as isize;
        let prev_index = indexes[current_index as usize - 1];
        let next_index = indexes[current_index as usize + 1];
        let left = current_index as i32 - prev_index as i32;
        let right = next_index as i32 - current_index as i32;
        answer[i] = left.min(right);
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        solve_queries(vec![1, 3, 1, 4, 1, 3, 2], vec![0, 3, 5])
    ); // [2,-1,3]
       // println!("{:?}", solve_queries(vec![1, 2, 3, 4], vec![0, 1, 2, 3])); // [-1,-1,-1,-1]
}
