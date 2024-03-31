// https://leetcode.com/problems/harshad-number/description/
pub fn sum_of_the_digits_of_harshad_number(x: i32) -> i32 {
    let sum = x.to_string().chars().map(|c| c as i32 - '0' as i32).sum();
    if x % sum == 0 {
        sum
    } else {
        -1
    }
}

fn main() {
    println!("{}", sum_of_the_digits_of_harshad_number(18)); // 19
    println!("{}", sum_of_the_digits_of_harshad_number(23)); // -1
}
