use std::collections::HashMap;

// https://leetcode.com/problems/counting-elements/
pub fn count_elements(arr: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in arr.iter() {
        *map.entry(*num).or_insert(0) += 1;
    }
    let mut answer = 0;
    for n in arr.iter() {
        if let Some(count) = map.get_mut(&(*n + 1)) {
            if *count > 0 {
                answer += 1;
            } else {
                *count -= 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", count_elements(vec![1, 2, 3])); // 2
    println!("{}", count_elements(vec![1, 1, 3, 3, 5, 5, 7, 7])); // 0
    println!("{}", count_elements(vec![1, 1, 2, 2, 3, 3])); // 4
}
