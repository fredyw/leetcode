use std::collections::HashMap;

// https://leetcode.com/problems/find-smallest-common-element-in-all-rows/description/
pub fn smallest_common_element(mat: Vec<Vec<i32>>) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for i in 0..mat.len() {
        for j in 0..mat[i].len() {
            *map.entry(mat[i][j]).or_insert(0) += 1;
        }
    }
    for n in mat[0].iter() {
        if let Some(count) = map.get(&n) {
            if *count == mat.len() as i32 {
                return *n;
            }
        }
    }
    -1
}

fn main() {
    println!(
        "{}",
        smallest_common_element(vec![
            vec![1, 2, 3, 4, 5],
            vec![2, 4, 5, 8, 10],
            vec![3, 5, 7, 9, 11],
            vec![1, 3, 5, 7, 9]
        ])
    ); // 5
    println!(
        "{}",
        smallest_common_element(vec![vec![1, 2, 3], vec![2, 3, 4], vec![2, 3, 5]])
    ); // 2
}
