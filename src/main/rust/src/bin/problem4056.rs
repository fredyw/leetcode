// https://leetcode.com/problems/number-of-intersecting-interval-pairs-i/description/
pub fn count_intersecting_intervals(intervals: Vec<Vec<i32>>) -> i32 {
    let mut answer = 0;
    for i in 0..intervals.len() {
        for j in i + 1..intervals.len() {
            if intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0] {
                answer += 1;
            }
        }
    }
    answer
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
