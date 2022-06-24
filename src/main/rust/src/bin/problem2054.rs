// https://leetcode.com/problems/two-best-non-overlapping-events/
pub fn max_two_events(events: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        max_two_events(vec![vec![1, 3, 2], vec![4, 5, 2], vec![2, 4, 3]])
    ); // 4
    println!(
        "{}",
        max_two_events(vec![vec![1, 3, 2], vec![4, 5, 2], vec![1, 5, 5]])
    ); // 5
    println!(
        "{}",
        max_two_events(vec![vec![1, 5, 3], vec![1, 5, 1], vec![6, 6, 5]])
    ); // 8
}
