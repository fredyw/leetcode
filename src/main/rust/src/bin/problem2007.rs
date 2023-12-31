use std::collections::HashMap;

// https://leetcode.com/problems/find-original-array-from-doubled-array/description/
pub fn find_original_array(mut changed: Vec<i32>) -> Vec<i32> {
    fn update(map: &mut HashMap<i32, i32>, n: i32) {
        if let Some(count) = map.get_mut(&n) {
            *count -= 1;
            if *count == 0 {
                map.remove(&n);
            }
        }
    }

    if changed.len() % 2 != 0 {
        return vec![];
    }
    let mut map: HashMap<i32, i32> = HashMap::new();
    for e in changed.iter() {
        *map.entry(*e).or_insert(0) += 1;
    }
    changed.sort();
    let mut answer = vec![];
    for &n in changed.iter() {
        if !map.contains_key(&n) {
            continue;
        }
        if !map.contains_key(&(n * 2)) {
            return vec![];
        }
        update(&mut map, n);
        update(&mut map, n * 2);
        answer.push(n);
    }
    answer
}

fn main() {
    println!("{:?}", find_original_array(vec![1, 3, 4, 2, 6, 8])); // [1,3,4]
    println!("{:?}", find_original_array(vec![6, 3, 0, 1])); // []
    println!("{:?}", find_original_array(vec![1])); // []
    println!("{:?}", find_original_array(vec![1, 2, 2, 1])); // [1,1]
    println!("{:?}", find_original_array(vec![1, 2, 1])); // []
    println!("{:?}", find_original_array(vec![0, 0, 0, 0])); // [0, 0]
}
