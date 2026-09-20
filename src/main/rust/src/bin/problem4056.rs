// https://leetcode.com/problems/number-of-intersecting-interval-pairs-i/description/
pub fn count_intersecting_intervals(intervals: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        count_intersecting_intervals(vec![vec![1, 2], vec![2, 3], vec![3, 4]])
    ); // 2
    println!(
        "{}",
        count_intersecting_intervals(vec![vec![1, 5], vec![2, 4], vec![3, 6]])
    ); // 3
    println!(
        "{}",
        count_intersecting_intervals(vec![vec![1, 2], vec![3, 4], vec![5, 6]])
    ); // 0
}
