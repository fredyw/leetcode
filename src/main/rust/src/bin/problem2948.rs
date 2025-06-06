use std::collections::HashMap;

// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
pub fn lexicographically_smallest_array(mut nums: Vec<i32>, limit: i32) -> Vec<i32> {
    let mut sorted_nums = nums.clone();
    sorted_nums.sort();
    let mut groups: Vec<Vec<i32>> = vec![];
    let mut map: HashMap<i32, usize> = HashMap::new();
    let mut same_group = false;
    for i in 0..sorted_nums.len() - 1 {
        if sorted_nums[i + 1] - sorted_nums[i] <= limit {
            if !same_group {
                groups.push(vec![]);
            }
            groups.last_mut().unwrap().push(sorted_nums[i]);
            map.insert(sorted_nums[i], groups.len() - 1);
            same_group = true;
        } else {
            if same_group {
                groups.last_mut().unwrap().push(sorted_nums[i]);
                map.insert(sorted_nums[i], groups.len() - 1);
            }
            same_group = false;
        }
    }
    if same_group {
        groups
            .last_mut()
            .unwrap()
            .push(sorted_nums[sorted_nums.len() - 1]);
        map.insert(sorted_nums[sorted_nums.len() - 1], groups.len() - 1);
    }
    let mut group_index: HashMap<usize, usize> = HashMap::new();
    for i in 0..nums.len() {
        if let Some(idx) = map.get(&nums[i]) {
            let cur_idx = group_index.entry(*idx).or_insert(0);
            nums[i] = groups[*idx][*cur_idx];
            *cur_idx += 1;
        }
    }
    nums
}

fn main() {
    println!(
        "{:?}",
        lexicographically_smallest_array(vec![1, 5, 3, 9, 8], 2)
    ); // [1,3,5,8,9]
    println!(
        "{:?}",
        lexicographically_smallest_array(vec![1, 7, 6, 18, 2, 1], 3)
    ); // [1,6,7,18,1,2]
    println!(
        "{:?}",
        lexicographically_smallest_array(vec![1, 7, 28, 19, 10], 3)
    ); // [1,7,28,19,10]
    println!(
        "{:?}",
        lexicographically_smallest_array(vec![1, 60, 34, 84, 62, 56, 39, 76, 49, 38], 4)
    ); // [1,56,34,84,60,62,38,76,49,39]
}
