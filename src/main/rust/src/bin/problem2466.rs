use std::collections::HashMap;

// https://leetcode.com/problems/count-ways-to-build-good-strings/
pub fn count_good_strings(low: i32, high: i32, zero: i32, one: i32) -> i32 {
    fn count_good_strings(
        low: i64,
        high: i64,
        zero: i64,
        one: i64,
        length: i64,
        memo: &mut HashMap<i64, i64>,
    ) -> i64 {
        if length > high {
            return 0;
        }
        if let Some(m) = memo.get(&length) {
            return *m;
        }
        let good_string = if length >= low && length <= high {
            1
        } else {
            0
        };
        let count = (count_good_strings(low, high, zero, one, length + zero, memo)
            + count_good_strings(low, high, zero, one, length + one, memo)
            + good_string)
            % 1000000007;
        memo.insert(length, count);
        count
    }

    let mut memo: HashMap<i64, i64> = HashMap::new();
    count_good_strings(
        low as i64,
        high as i64,
        zero as i64,
        one as i64,
        0,
        &mut memo,
    ) as i32
}

fn main() {
    println!("{}", count_good_strings(3, 3, 1, 1)); // 8
    println!("{}", count_good_strings(2, 3, 1, 2)); // 5
    println!("{}", count_good_strings(10, 3000, 2, 5)); // 5
}
