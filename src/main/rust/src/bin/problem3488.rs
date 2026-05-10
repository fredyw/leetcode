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
        let index = indexes.binary_search(&i).unwrap() as isize;
        let left = if index - 1 == 0 {
            nums.len() - indexes[indexes.len() - 1]
        } else {
            index as usize - 1
        };
        let right = if index + 1 == nums.len() as isize {
            indexes[0]
        } else {
            nums.len() - index as usize + 1
        };
        answer[i] = left.min(right) as i32;
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        solve_queries(vec![1, 3, 1, 4, 1, 3, 2], vec![0, 3, 5])
    ); // [2,-1,3]
    println!("{:?}", solve_queries(vec![1, 2, 3, 4], vec![0, 1, 2, 3])); // [-1,-1,-1,-1]
}
