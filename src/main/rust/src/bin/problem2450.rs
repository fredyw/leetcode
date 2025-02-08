// https://leetcode.com/problems/number-of-distinct-binary-strings-after-applying-operations/description/
pub fn count_distinct_strings(s: String, k: i32) -> i32 {
    let answer: u64 = 2u64.pow(s.len() as u32) / 2u64.pow(k as u32 - 1);
    (answer % 1_000_000_007) as i32
}

fn main() {
    println!("{}", count_distinct_strings("1001".to_string(), 3)); // 4
    println!("{}", count_distinct_strings("10110".to_string(), 5)); // 2
    println!("{}", count_distinct_strings("1001".to_string(), 2)); // 8
    println!("{}", count_distinct_strings("1111".to_string(), 3)); // 4
    println!("{}", count_distinct_strings("1100".to_string(), 3)); // 4
}
