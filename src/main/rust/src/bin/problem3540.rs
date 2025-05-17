// https://leetcode.com/problems/minimum-time-to-visit-all-houses/description/
pub fn min_total_time(forward: Vec<i32>, backward: Vec<i32>, queries: Vec<i32>) -> i64 {
    todo!()
}

fn main() {
    println!(
        "{}",
        min_total_time(vec![1, 4, 4], vec![4, 1, 2], vec![1, 2, 0, 2])
    ); // 12
    println!(
        "{}",
        min_total_time(vec![1, 1, 1, 1], vec![2, 2, 2, 2], vec![1, 2, 3, 0])
    ); // 4
}
