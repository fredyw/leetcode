// https://leetcode.com/problems/sum-multiples/
pub fn sum_of_multiples(n: i32) -> i32 {
    let mut answer = 0;
    for i in 1..=n {
        if i % 3 == 0 || i % 5 == 0 || i % 7 == 0 {
            answer += i;
        }
    }
    answer
}

fn main() {
    println!("{}", sum_of_multiples(7)); // 21
    println!("{}", sum_of_multiples(10)); // 40
    println!("{}", sum_of_multiples(9)); // 30
}
