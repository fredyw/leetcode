// https://leetcode.com/problems/sum-of-primes-between-number-and-its-reverse/description/
pub fn sum_of_primes_in_range(n: i32) -> i32 {
    let m = n
        .to_string()
        .chars()
        .rev()
        .collect::<String>()
        .parse::<i32>()
        .unwrap();
    let start = if n < m { n } else { m } as usize;
    let end = if n >= m { n } else { m } as usize;
    let mut is_prime: Vec<bool> = vec![true; end + 1];
    is_prime[0] = false;
    is_prime[1] = false;
    for i in 2..=(end as f32).sqrt() as usize {
        if is_prime[i] {
            let mut j = i + i;
            while j <= end {
                is_prime[j] = false;
                j += i;
            }
        }
    }
    is_prime
        .iter()
        .enumerate()
        .filter(|&(i, is_prime)| *is_prime && i >= start && i <= end)
        .map(|(i, _)| i as i32)
        .sum()
}

fn main() {
    println!("{}", sum_of_primes_in_range(13)); // 132
    println!("{}", sum_of_primes_in_range(10)); // 17
    println!("{}", sum_of_primes_in_range(8)); // 0
}
