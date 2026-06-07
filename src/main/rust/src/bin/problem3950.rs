// https://leetcode.com/problems/exactly-one-consecutive-set-bits-pair
pub fn consecutive_set_bits(n: i32) -> bool {
    let binary_string = format!("{:b}", n);
    let bytes = binary_string.as_bytes();
    let mut is_consecutive_set_bits = false;
    let mut consecutive_set_bits_count = 0;
    for i in 0..bytes.len() - 1 {
        if bytes[i] == b'1' && bytes[i + 1] == b'1' {
            if is_consecutive_set_bits {
                return false;
            }
            consecutive_set_bits_count += 1;
            is_consecutive_set_bits = true;
        } else {
            is_consecutive_set_bits = false;
        }
        if consecutive_set_bits_count > 1 {
            break;
        }
    }
    consecutive_set_bits_count == 1
}

fn main() {
    println!("{}", consecutive_set_bits(6)); // true
    println!("{}", consecutive_set_bits(5)); // false
    println!("{}", consecutive_set_bits(30)); // false
}
