// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/
pub fn merge_arrays(nums1: Vec<Vec<i32>>, nums2: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    todo!()
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
