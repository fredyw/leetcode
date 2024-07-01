// https://leetcode.com/problems/number-of-days-in-a-month/description/
pub fn number_of_days(year: i32, month: i32) -> i32 {
    pub fn is_leap_year(year: i32) -> bool {
        year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
    }

    match month {
        2 => {
            if is_leap_year(year) {
                29
            } else {
                28
            }
        }
        4 | 6 | 9 | 11 => 30,
        _ => 31,
    }
}

fn main() {
    println!("{}", number_of_days(1992, 7)); // 31
    println!("{}", number_of_days(2000, 2)); // 29
    println!("{}", number_of_days(1900, 2)); // 28
}
