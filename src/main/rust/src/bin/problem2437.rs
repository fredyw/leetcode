// https://leetcode.com/problems/number-of-valid-clock-times/
pub fn count_time(time: String) -> i32 {
    let time = time.as_bytes();
    let first = if time[0] == '?' as u8 && time[1] == '?' as u8 {
        "2".to_string()
    } else if time[0] == '?' as u8 && time[1] - '0' as u8 <= 3 {
        "2".to_string()
    } else if time[0] == '?' as u8 && time[1] - '0' as u8 > 3 {
        "1".to_string()
    } else {
        "".to_string()
    };
    let second = if time[0] == '?' as u8 && time[1] == '?' as u8 {
        "3".to_string()
    } else if time[0] == '2' as u8 && time[1] == '?' as u8 {
        "3".to_string()
    } else if (time[0] == '1' as u8 || time[0] == '0' as u8) && time[1] == '?' as u8 {
        "9".to_string()
    } else {
        "".to_string()
    };
    let third = if time[3] == '?' as u8 {
        "5".to_string()
    } else {
        "".to_string()
    };
    let fourth = if time[4] == '?' as u8 {
        "9".to_string()
    } else {
        "".to_string()
    };
    let hours = format!("{}{}", first, second).parse::<i32>().unwrap_or(0);
    let minutes = format!("{}{}", third, fourth).parse::<i32>().unwrap_or(0);
    (hours + 1) * (minutes + 1)
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
