// https://leetcode.com/problems/count-monobit-integers/description/
pub fn count_monobit(n: i32) -> i32 {
    let mut answer = 0;
    for i in 0..=n {
        let length = u32::BITS - i.leading_zeros();
        if i.count_ones() == length || i.count_zeros() == length {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", count_monobit(1)); // 2
    println!("{}", count_monobit(4)); // 3
}
