// https://leetcode.com/problems/confusing-number/description/
pub fn confusing_number(n: i32) -> bool {
    let mut chars: Vec<char> = n.to_string().chars().collect();
    for char in chars.iter_mut() {
        *char = match *char {
            '6' => '9',
            '9' => '6',
            '0' | '1' | '8' => *char,
            _ => return false,
        };
    }
    n != chars
        .into_iter()
        .rev()
        .collect::<String>()
        .parse::<i32>()
        .unwrap()
}

fn main() {
    println!("{}", confusing_number(6)); // true
    println!("{}", confusing_number(89)); // true
    println!("{}", confusing_number(11)); // false
    println!("{}", confusing_number(123)); // false
    println!("{}", confusing_number(100)); // true
    println!("{}", confusing_number(916)); // false
}
