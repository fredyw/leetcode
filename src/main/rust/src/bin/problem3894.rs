// https://leetcode.com/problems/traffic-signal-color/description/
pub fn traffic_signal(timer: i32) -> String {
    if timer == 0 {
        "Green".into()
    } else if timer == 30 {
        "Orange".into()
    } else if timer > 30 && timer <= 90 {
        "Red".into()
    } else {
        "Invalid".into()
    }
}

fn main() {
    println!("{}", traffic_signal(60)); // "Red"
    println!("{}", traffic_signal(5)); // "Invalid"
}
