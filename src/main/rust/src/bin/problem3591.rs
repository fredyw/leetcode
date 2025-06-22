use std::collections::HashMap;

// https://leetcode.com/problems/check-if-any-element-has-prime-frequency/description/
pub fn check_prime_frequency(nums: Vec<i32>) -> bool {
    fn is_prime(n: i32) -> bool {
        if n == 1 {
            return false;
        }
        if n == 2 {
            return true;
        }
        for i in 2..=(n as f64).sqrt() as i32 {
            if n % i == 0 {
                return false;
            }
        }
        true
    }

    let mut map: HashMap<i32, i32> = HashMap::new();
    for num in nums.iter() {
        *map.entry(*num).or_insert(0) += 1;
    }
    map.values().any(|&count| is_prime(count))
}

fn main() {
    println!("{}", check_prime_frequency(vec![1, 2, 3, 4, 5, 4])); // true
    println!("{}", check_prime_frequency(vec![1, 2, 3, 4, 5])); // false
    println!("{}", check_prime_frequency(vec![2, 2, 2, 4, 4])); // true
}
