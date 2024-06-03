// https://leetcode.com/problems/maximum-prime-difference/description/
pub fn maximum_prime_difference(nums: Vec<i32>) -> i32 {
    fn sieve_of_eratosthenes(n: usize) -> Vec<bool> {
        let mut primes: Vec<bool> = vec![true; n];
        primes[0] = false;
        let mut p = 2;
        while p * p <= n {
            if primes[p - 1] {
                let mut i = p + p;
                while i <= n {
                    primes[i - 1] = false;
                    i += p;
                }
            }
            p += 1;
        }
        primes
    }

    let primes = sieve_of_eratosthenes(100);
    let mut i = 0;
    while !primes[nums[i] as usize - 1] {
        i += 1;
    }
    let mut j = nums.len() - 1;
    while !primes[nums[j] as usize - 1] {
        j -= 1;
    }
    (j - i) as i32
}

fn main() {
    println!("{}", maximum_prime_difference(vec![4, 2, 9, 5, 3])); // 3
    println!("{}", maximum_prime_difference(vec![4, 8, 2, 8])); // 0
    println!("{}", maximum_prime_difference(vec![1, 7])); // 0
}
