// https://leetcode.com/problems/number-of-self-divisible-permutations/description/
pub fn self_divisible_permutation_count(n: i32) -> i32 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            gcd(b, a % b)
        }
    }

    fn self_divisible_permutation_count(nums: &mut Vec<i32>, index: usize) -> i32 {
        if index == nums.len() {
            return 1;
        }
        let mut count = 0;
        for i in index..nums.len() {
            nums.swap(i, index);
            if gcd(nums[index], index as i32 + 1) == 1 {
                count += self_divisible_permutation_count(nums, index + 1);
            }
            nums.swap(i, index);
        }
        count
    }

    let mut nums: Vec<i32> = vec![];
    for i in 1..=n {
        nums.push(i);
    }
    self_divisible_permutation_count(&mut nums, 0)
}

fn main() {
    println!("{}", self_divisible_permutation_count(1)); // 1
    println!("{}", self_divisible_permutation_count(2)); // 1
    println!("{}", self_divisible_permutation_count(3)); // 3
    println!("{}", self_divisible_permutation_count(4)); // 4
    println!("{}", self_divisible_permutation_count(5)); // 28
    println!("{}", self_divisible_permutation_count(12)); // 63504
}
