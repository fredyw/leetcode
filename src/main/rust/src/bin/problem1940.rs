// https://leetcode.com/problems/longest-common-subsequence-between-sorted-arrays/description/
pub fn longest_common_subsequence(arrays: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        longest_common_subsequence(vec![vec![1, 3, 4], vec![1, 4, 7, 9]])
    ); // [1,4]
    println!(
        "{:?}",
        longest_common_subsequence(vec![
            vec![2, 3, 6, 8],
            vec![1, 2, 3, 5, 6, 7, 10],
            vec![2, 3, 4, 6, 9]
        ])
    ); // [2,3,6]
    println!(
        "{:?}",
        longest_common_subsequence(vec![vec![1, 2, 3, 4, 5], vec![6, 7, 8]])
    ); // []
}
