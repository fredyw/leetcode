use std::collections::HashMap;

// https://leetcode.com/problems/maximize-ysum-by-picking-a-triplet-of-distinct-xvalues/description/
pub fn max_sum_distinct_triplet(x: Vec<i32>, y: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for i in 0..x.len() {
        map.entry(x[i])
            .and_modify(|n| *n = (*n).max(y[i]))
            .or_insert(y[i]);
    }
    let mut v: Vec<i32> = map.into_iter().map(|(_, v)| v).collect();
    v.sort_unstable();
    if v.len() <= 2 {
        -1
    } else {
        v[v.len() - 2] + v[v.len() - 1] + v[v.len() - 3]
    }
}

fn main() {
    println!(
        "{}",
        max_sum_distinct_triplet(vec![1, 2, 1, 3, 2], vec![5, 3, 4, 6, 2])
    ); // 14
    println!(
        "{}",
        max_sum_distinct_triplet(vec![1, 2, 1, 2], vec![4, 5, 6, 7])
    ); // -1
}
