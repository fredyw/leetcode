// https://leetcode.com/problems/number-of-valid-clock-times/
pub fn count_time(time: String) -> i32 {
    let time = time.as_bytes();
    let hh = match (time[0], time[1]) {
        (b'?', b'?') => 24,
        (b'?', b'0'..=b'3') => 3,
        (b'?', _) => 2,
        (b'0'..=b'1', b'?') => 10,
        (b'2', b'?') => 4,
        _ => 1,
    };
    let mm = match (time[3], time[4]) {
        (b'?', b'?') => 60,
        (b'?', _) => 6,
        (_, b'?') => 10,
        _ => 1,
    };
    hh * mm
}

fn main() {
    println!("{}", count_time("?5:00".to_string())); // 2
    println!("{}", count_time("0?:0?".to_string())); // 100
    println!("{}", count_time("??:??".to_string())); // 1440
    println!("{}", count_time("0?:??".to_string())); // 600
    println!("{}", count_time("2?:?6".to_string())); // 24
    println!("{}", count_time("1?:26".to_string())); // 10
    println!("{}", count_time("1?:26".to_string())); // 10
    println!("{}", count_time("?3:26".to_string())); // 3
}
