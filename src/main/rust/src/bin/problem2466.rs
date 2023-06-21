// https://leetcode.com/problems/count-ways-to-build-good-strings/
pub fn count_good_strings(low: i32, high: i32, zero: i32, one: i32) -> i32 {
    fn count_good_strings(low: i32, high: i32, zero: i32, one: i32, length: i32) -> i64 {
        if length > high {
            return 0;
        }
        let good_string = if length >= low && length <= high {
            1
        } else {
            0
        };
        let count = count_good_strings(low, high, zero, one, length + zero)
            + count_good_strings(low, high, zero, one, length + one)
            + good_string;
        count % 10000000007
    }

    count_good_strings(low, high, zero, one, 0) as i32
}

fn main() {
    println!("{}", count_good_strings(3, 3, 1, 1)); // 8
    println!("{}", count_good_strings(2, 3, 1, 2)); // 5
    println!("{}", count_good_strings(10, 3000, 2, 5)); // 5
}
