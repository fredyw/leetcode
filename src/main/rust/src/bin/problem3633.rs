// https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/description/
pub fn earliest_finish_time(
    land_start_time: Vec<i32>,
    land_duration: Vec<i32>,
    water_start_time: Vec<i32>,
    water_duration: Vec<i32>,
) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        earliest_finish_time(vec![2, 8], vec![4, 1], vec![6], vec![3])
    ); // 9
    println!(
        "{}",
        earliest_finish_time(vec![5], vec![3], vec![1], vec![10])
    ); // 14
}
