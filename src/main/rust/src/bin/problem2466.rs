// https://leetcode.com/problems/count-ways-to-build-good-strings/
pub fn count_good_strings(low: i32, high: i32, zero: i32, one: i32) -> i32 {
    fn count_good_strings(
        low: i32,
        high: i32,
        zero: i32,
        one: i32,
        length: i32,
        memo: &mut Vec<i64>,
    ) -> i64 {
        if length > high {
            return 0;
        }
        if memo[length as usize] != -1 {
            return memo[length as usize];
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
        memo[length as usize] = count;
        count
    }

    let mut memo: Vec<i64> = vec![-1; high as usize + 1];
    count_good_strings(low, high, zero, one, 0, &mut memo) as i32
}

fn main() {
    println!("{}", count_good_strings(3, 3, 1, 1)); // 8
    println!("{}", count_good_strings(2, 3, 1, 2)); // 5
    println!("{}", count_good_strings(10, 3000, 2, 5)); // 445662790
}
