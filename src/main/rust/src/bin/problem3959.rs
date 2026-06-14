// https://leetcode.com/problems/check-good-integer/description/
pub fn check_good_integer(n: i32) -> bool {
    let mut digit_sum = 0;
    let mut square_sum = 0;
    for c in n.to_string().chars() {
        let n = c as i32 - b'0' as i32;
        digit_sum += n;
        square_sum += n * n;
    }
    square_sum - digit_sum >= 50
}

fn main() {
    println!("{}", check_good_integer(1000)); // false
    println!("{}", check_good_integer(19)); // true
}
