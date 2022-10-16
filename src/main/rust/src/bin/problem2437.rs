// https://leetcode.com/problems/number-of-valid-clock-times/
pub fn count_time(time: String) -> i32 {
    todo!()
}

fn main() {
    println!("{}", count_time("?5:00".to_string())); // 2
    println!("{}", count_time("0?:0?".to_string())); // 100
    println!("{}", count_time("??:??".to_string())); // 1440
}