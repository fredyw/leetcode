// https://leetcode.com/problems/number-of-elapsed-seconds-between-two-times/description/
pub fn seconds_between_times(start_time: String, end_time: String) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        seconds_between_times("01:00:00".to_string(), "01:00:25".to_string())
    ); // 25
    println!(
        "{}",
        seconds_between_times("12:34:56".to_string(), "13:00:00".to_string())
    ); // 1504
}
