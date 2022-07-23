// https://leetcode.com/problems/number-of-people-aware-of-a-secret/
pub fn people_aware_of_secret(n: i32, delay: i32, forget: i32) -> i32 {
    fn f(n: i32, delay: i32, forget: i32, day: i32, memo: &mut Vec<Vec<i64>>) -> i64 {
        if day > n {
            return 0;
        }
        let secret_day = day + delay;
        if memo[n as usize][secret_day as usize] != -1 {
            return memo[n as usize][secret_day as usize];
        }
        let mut sum: i64 = if day + forget <= n { 0 } else { 1 };
        for d in secret_day..(secret_day + (forget - delay)) {
            sum += f(n, delay, forget, d, memo) % 1_000_000_007;
        }
        memo[n as usize][secret_day as usize] = sum;
        sum
    }

    let mut memo = vec![vec![-1i64; (n + delay + 1) as usize]; (n + delay + 1) as usize];
    (f(n, delay, forget, 1, &mut memo) % 1_000_000_007) as i32
}

fn main() {
    println!("{}", people_aware_of_secret(6, 2, 4)); // 5
    println!("{}", people_aware_of_secret(4, 1, 3)); // 6
    println!("{}", people_aware_of_secret(10, 3, 5)); // 5
    println!("{}", people_aware_of_secret(10, 2, 4)); // 14
    println!("{}", people_aware_of_secret(1000, 500, 600)); // 100
    println!("{}", people_aware_of_secret(100, 20, 30)); // 6775
    println!("{}", people_aware_of_secret(1000, 2, 1000)); // 517691607
}
