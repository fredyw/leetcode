// https://leetcode.com/problems/maximum-bitwise-xor-after-rearrangement/description/
pub fn maximum_xor(s: String, t: String) -> String {
    let mut zero_count = 0;
    let mut one_count = 0;
    for c in t.chars() {
        if c == '0' {
            zero_count += 1;
        } else {
            one_count += 1;
        }
    }
    let mut answer = String::new();
    for c in s.chars() {
        if c == '0' {
            if one_count > 0 {
                answer.push('1');
                one_count -= 1;
            } else {
                answer.push('0');
            }
        } else {
            if zero_count > 0 {
                answer.push('1');
                zero_count -= 1;
            } else {
                answer.push('0');
            }
        }
    }
    answer
}

fn main() {
    println!("{}", maximum_xor("101".to_string(), "011".to_string())); // "110"
    println!("{}", maximum_xor("0110".to_string(), "1110".to_string())); // "1101"
    println!("{}", maximum_xor("0101".to_string(), "1001".to_string())); // "1111"
}
