// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/
pub fn min_groups(intervals: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        min_groups(vec![
            vec![5, 10],
            vec![6, 8],
            vec![1, 5],
            vec![2, 3],
            vec![1, 10]
        ])
    ); // 3
    println!(
        "{}",
        min_groups(vec![vec![1, 3], vec![5, 6], vec![8, 10], vec![11, 13]])
    ); // 1
    println!(
        "{}",
        min_groups(vec![
            vec![1, 2],
            vec![1, 5],
            vec![1, 7],
            vec![3, 5],
            vec![4, 8],
            vec![5, 6],
            vec![7, 10]
        ])
    ); // 5
}
