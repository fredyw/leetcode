// https://leetcode.com/problems/check-adjacent-digit-differences/description/
pub fn is_adjacent_diff_at_most_two(s: String) -> bool {
    let bytes = s.as_bytes();
    for i in 0..bytes.len() - 1 {
        if (bytes[i] as i32 - bytes[i + 1] as i32).abs() > 2 {
            return false;
        }
    }
    true
}

fn main() {
    println!("{}", is_adjacent_diff_at_most_two("132".to_string())); // true
    println!("{}", is_adjacent_diff_at_most_two("129".to_string())); // false
}
