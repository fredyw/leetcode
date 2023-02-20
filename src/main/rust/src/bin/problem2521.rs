use std::collections::HashSet;

// https://leetcode.com/problems/distinct-prime-factors-of-product-of-array/
pub fn distinct_prime_factors(nums: Vec<i32>) -> i32 {
    fn distinct_prime_factors(n: i32, set: &mut HashSet<i32>) {
        for i in 2..n {
            if n % i == 0 {
                distinct_prime_factors(i, set);
                distinct_prime_factors(n / i, set);
                return;
            }
        }
        set.insert(n);
    }

    let nums: HashSet<i32> = nums.into_iter().collect();
    let mut set: HashSet<i32> = HashSet::new();
    for num in nums {
        distinct_prime_factors(num, &mut set);
    }
    set.len() as i32
}

fn main() {
    println!("{}", distinct_prime_factors(vec![2, 4, 3, 7, 10, 6])); // 4
    println!("{}", distinct_prime_factors(vec![2, 4, 8, 16])); // 1
    println!("{}", distinct_prime_factors(vec![5])); // 1
    println!(
        "{}",
        distinct_prime_factors(vec![2, 14, 19, 19, 5, 13, 18, 10, 15, 20])
    ); // 6
}
