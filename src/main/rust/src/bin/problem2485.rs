// https://leetcode.com/problems/find-the-pivot-integer/
pub fn pivot_integer(n: i32) -> i32 {
    let total_sum: i32 = (1..=n).into_iter().sum();
    let mut sum = 0;
    for i in 1..=n {
        sum += i;
        if sum == total_sum - sum + i {
            return i;
        }
    }
    -1
}

fn main() {
    println!("{}", pivot_integer(8)); // 6
    println!("{}", pivot_integer(1)); // 1
    println!("{}", pivot_integer(4)); // -1
}
