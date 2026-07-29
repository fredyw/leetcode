// https://leetcode.com/problems/largest-integer-with-given-digit-sum/description/
pub fn largest_integer(n: i32, s: i32) -> i32 {
    let mut answer = -1;
    for i in 0..10usize.pow(n as u32) {
        let sum = i
            .to_string()
            .chars()
            .map(|x| x as i32 - '0' as i32)
            .sum::<i32>();
        if sum == s {
            answer = answer.max(i as i32);
        }
    }
    answer
}

fn main() {
    println!("{}", largest_integer(2, 9)); // 90
    println!("{}", largest_integer(2, 19)); // -1
    println!("{}", largest_integer(5, 0)); // 0
}
