use std::collections::HashMap;

// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/
pub fn merge_arrays(nums1: Vec<Vec<i32>>, nums2: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in nums1.iter() {
        let id = num[0];
        let value = num[1];
        *map.entry(id).or_insert(0) += value;
    }
    for num in nums2.iter() {
        let id = num[0];
        let value = num[1];
        *map.entry(id).or_insert(0) += value;
    }
    let mut answer: Vec<Vec<i32>> = map
        .iter()
        .map(|(id, num)| {
            let mut v = vec![];
            v.push(*id);
            v.push(*num);
            v
        })
        .collect();
    answer.sort_by(|a, b| a[0].cmp(&b[0]));
    answer
}

fn main() {
    println!(
        "{:?}",
        merge_arrays(
            vec![vec![1, 2], vec![2, 3], vec![4, 5]],
            vec![vec![1, 4], vec![3, 2], vec![4, 1]]
        )
    ); // [[1,6],[2,3],[3,2],[4,6]]
    println!(
        "{:?}",
        merge_arrays(
            vec![vec![2, 4], vec![3, 6], vec![5, 5]],
            vec![vec![1, 3], vec![4, 3]]
        )
    ); // [[1,3],[2,4],[3,6],[4,3],[5,5]]
}
