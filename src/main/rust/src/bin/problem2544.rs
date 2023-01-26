// https://leetcode.com/problems/alternating-digit-sum/
pub fn alternate_digit_sum(n: i32) -> i32 {
    let mut answer: i32 = 0;
    let s = format!("{}", n);
    let bytes = s.as_bytes();
    let mut positive = true;
    for b in bytes.iter() {
        let num = *b - '0' as u8;
        if positive {
            answer += num as i32;
        } else {
            answer += -(num as i32);
        }
        positive = !positive;
    }
    answer
}

fn main() {
    println!("{}", alternate_digit_sum(521)); // 4
    println!("{}", alternate_digit_sum(111)); // 1
    println!("{}", alternate_digit_sum(886996)); // 0
}
