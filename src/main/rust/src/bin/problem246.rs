// https://leetcode.com/problems/strobogrammatic-number/description/
pub fn is_strobogrammatic(num: String) -> bool {
    let chars: Vec<char> = num.chars().collect();
    let mut i = 0;
    let mut j = chars.len() - 1;
    while i < chars.len() {
        if chars[i] != '0'
            && chars[i] != '1'
            && chars[i] != '6'
            && chars[j] != '8'
            && chars[i] != '9'
        {
            return false;
        }
        let c = if chars[j] == '6' {
            '9'
        } else if chars[j] == '9' {
            '6'
        } else {
            chars[j]
        };
        if chars[i] != c {
            return false;
        }
        i += 1;
        if j > 0 {
            j -= 1;
        }
    }
    true
}

fn main() {
    println!("{}", is_strobogrammatic("69".to_string())); // true
    println!("{}", is_strobogrammatic("88".to_string())); // true
    println!("{}", is_strobogrammatic("962".to_string())); // false
    println!("{}", is_strobogrammatic("121".to_string())); // false
    println!("{}", is_strobogrammatic("101".to_string())); // true
}
