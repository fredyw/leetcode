use std::collections::HashMap;

// https://leetcode.com/problems/intervals-between-identical-elements/
pub fn get_distances(arr: Vec<i32>) -> Vec<i64> {
    let mut map: HashMap<i32, Vec<usize>> = HashMap::new();
    for (i, num) in arr.iter().enumerate() {
        map.entry(*num).or_insert(vec![]).push(i);
    }
    let mut answer = vec![0; arr.len()];
    for (i, num) in arr.iter().enumerate() {
        let mut sum: i64 = 0;
        for j in map[num].iter() {
            if i == *j {
                continue;
            }
            sum += i64::abs(i as i64 - *j as i64)
        }
        answer[i] = sum;
    }
    answer
}

fn main() {
    println!("{:?}", get_distances(vec![2, 1, 3, 1, 2, 3, 3])); // [4,2,7,2,4,4,5]
    println!("{:?}", get_distances(vec![10, 5, 10, 10])); // [5,0,3,4]
}
