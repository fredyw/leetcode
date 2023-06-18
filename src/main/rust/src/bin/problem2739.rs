use std::cmp::min;

// https://leetcode.com/problems/total-distance-traveled/
pub fn distance_traveled(mut main_tank: i32, mut additional_tank: i32) -> i32 {
    let mut answer = 0;
    while main_tank > 0 {
        if main_tank >= 5 {
            if additional_tank > 0 {
                main_tank += 1;
                additional_tank -= 1;
            }
        }
        let min_tank = min(main_tank, 5);
        main_tank -= min(min_tank, 5);
        answer += min_tank * 10;
    }
    answer
}

fn main() {
    println!("{}", distance_traveled(5, 10)); // 60
    println!("{}", distance_traveled(1, 2)); // 10
    println!("{}", distance_traveled(9, 2)); // 110
    println!("{}", distance_traveled(100, 4)); // 1040
    println!("{}", distance_traveled(100, 68)); // 1240
}
