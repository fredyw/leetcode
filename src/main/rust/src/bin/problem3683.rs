// https://leetcode.com/problems/earliest-time-to-finish-one-task/description/
pub fn earliest_time(tasks: Vec<Vec<i32>>) -> i32 {
    tasks.iter().map(|x| x[0] + x[1]).min().unwrap()
}

fn main() {
    println!("{}", earliest_time(vec![vec![1, 6], vec![2, 3]])); // 5
    println!(
        "{}",
        earliest_time(vec![vec![100, 100], vec![100, 100], vec![100, 100]])
    ); // 200
}
