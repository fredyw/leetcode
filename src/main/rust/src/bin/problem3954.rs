// https://leetcode.com/problems/sum-of-compatible-numbers-in-range-i
pub fn sum_of_good_integers(n: i32, k: i32) -> i32 {
    let mut answer = 0;
    let start = 1.max(n - k);
    let end = n + k;
    for x in start..=end {
        if (n & x) == 0 {
            answer += x;
        }
    }
    answer
}

fn main() {
    println!("{}", sum_of_good_integers(2, 3)); // 10
    println!("{}", sum_of_good_integers(5, 1)); // 0
    println!("{}", sum_of_good_integers(1, 13)); // 56
}
