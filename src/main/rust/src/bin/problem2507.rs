use std::collections::HashMap;

// https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/
pub fn smallest_value(n: i32) -> i32 {
    fn sum_prime_factors(n: i32, memo: &mut HashMap<i32, i32>) -> i32 {
        if let Some(sum) = memo.get(&n) {
            return *sum;
        }
        for i in 2..n {
            if n % i == 0 {
                let sum = sum_prime_factors(i, memo) + sum_prime_factors(n / i, memo);
                memo.insert(n, sum);
                return sum;
            }
        }
        memo.insert(n, n);
        n
    }

    let mut memo: HashMap<i32, i32> = HashMap::new();
    let mut answer = sum_prime_factors(n, &mut memo);
    let mut prev_answer = 0;
    while answer != prev_answer {
        prev_answer = answer;
        answer = sum_prime_factors(prev_answer, &mut memo);
    }
    answer
}

fn main() {
    println!("{}", smallest_value(15)); // 5
    println!("{}", smallest_value(3)); // 3
    println!("{}", smallest_value(12)); // 7
    println!("{}", smallest_value(100000)); // 7
}
