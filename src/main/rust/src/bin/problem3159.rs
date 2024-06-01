use std::collections::HashMap;

// https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/
pub fn occurrences_of_element(nums: Vec<i32>, queries: Vec<i32>, x: i32) -> Vec<i32> {
    let mut map: HashMap<i32, Vec<usize>> = HashMap::new();
    for (i, num) in nums.into_iter().enumerate() {
        map.entry(num).or_insert(vec![]).push(i);
    }
    let mut answer: Vec<i32> = vec![-1; queries.len()];
    for (i, query) in queries.iter().enumerate() {
        if let Some(v) = map.get(&x) {
            if *query as usize - 1 < v.len() {
                answer[i] = v[*query as usize - 1] as i32;
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        occurrences_of_element(vec![1, 3, 1, 7], vec![1, 3, 2, 4], 1)
    ); // [0,-1,2,-1]
    println!("{:?}", occurrences_of_element(vec![1, 2, 3], vec![10], 5)); // [-1]
}
