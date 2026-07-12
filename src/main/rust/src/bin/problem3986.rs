use itertools::Itertools;

// https://leetcode.com/problems/number-of-elapsed-seconds-between-two-times/description/
pub fn seconds_between_times(start_time: String, end_time: String) -> i32 {
    let (start_hour, start_minute, start_second) = start_time.split(":").collect_tuple().unwrap();
    let (end_hour, end_minute, end_second) = end_time.split(":").collect_tuple().unwrap();
    let hour = end_hour.parse::<i32>().unwrap() - start_hour.parse::<i32>().unwrap();
    let minute = end_minute.parse::<i32>().unwrap() - start_minute.parse::<i32>().unwrap();
    let second = end_second.parse::<i32>().unwrap() - start_second.parse::<i32>().unwrap();
    (hour * 60 * 60) + (minute * 60) + second
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
