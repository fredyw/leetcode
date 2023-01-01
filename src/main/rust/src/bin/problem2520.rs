// https://leetcode.com/problems/count-the-digits-that-divide-a-number/
pub fn count_digits(num: i32) -> i32 {
    let mut answer = 0;
    for b in num.to_string().as_bytes().into_iter() {
        if num % (b - '0' as u8) as i32 == 0 {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", count_digits(7)); // 1
    println!("{}", count_digits(121)); // 2
    println!("{}", count_digits(1248)); // 4
}
