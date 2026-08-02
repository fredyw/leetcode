// https://leetcode.com/problems/count-valid-prefixes/description/
pub fn count_valid_prefixes(s: String) -> i32 {
    let mut answer = 0;
    let mut zero_count = 0;
    let mut one_count = 0;
    for c in s.chars() {
        if c == '0' {
            zero_count += 1;
        } else {
            one_count += 1;
        }
        if zero_count == one_count || zero_count == (one_count + 1) || (zero_count + 1) == one_count
        {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", count_valid_prefixes("00101".to_string())); // 3
    println!("{}", count_valid_prefixes("101".to_string())); // 3
}
