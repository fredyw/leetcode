// https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/description/
pub fn earliest_finish_time(
    land_start_time: Vec<i32>,
    land_duration: Vec<i32>,
    water_start_time: Vec<i32>,
    water_duration: Vec<i32>,
) -> i32 {
    fn earliest_finish_time(
        a_start_time: &Vec<i32>,
        a_duration: &Vec<i32>,
        b_start_time: &Vec<i32>,
        b_duration: &Vec<i32>,
    ) -> i32 {
        let mut min_time = i32::MAX;
        for i in 0..a_start_time.len() {
            let time = a_start_time[i] + a_duration[i];
            for j in 0..b_start_time.len() {
                if time > b_start_time[j] {
                    min_time = min_time.min(time + b_duration[j]);
                } else {
                    min_time = min_time.min(b_start_time[j] + b_duration[j]);
                }
            }
        }
        min_time
    }

    earliest_finish_time(
        &land_start_time,
        &land_duration,
        &water_start_time,
        &water_duration,
    )
    .min(earliest_finish_time(
        &water_start_time,
        &water_duration,
        &land_start_time,
        &land_duration,
    ))
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
