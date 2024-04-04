// https://leetcode.com/problems/water-bottles-ii/description/
pub fn max_bottles_drunk(num_bottles: i32, mut num_exchange: i32) -> i32 {
    let mut answer = num_bottles;
    let mut empty_bottles = num_bottles;
    while empty_bottles - num_exchange >= 0 {
        empty_bottles -= num_exchange;
        num_exchange += 1;
        answer += 1;
        empty_bottles += 1;
    }
    answer
}

fn main() {
    println!("{}", max_bottles_drunk(13, 6)); // 15
    println!("{}", max_bottles_drunk(10, 3)); // 13
    println!("{}", max_bottles_drunk(20, 1)); // 26
    println!("{}", max_bottles_drunk(3, 1)); // 5
}
