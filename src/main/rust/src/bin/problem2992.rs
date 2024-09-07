use std::collections::HashSet;

// https://leetcode.com/problems/number-of-self-divisible-permutations/description/
pub fn self_divisible_permutation_count(n: i32) -> i32 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            gcd(b, a % b)
        }
    }

    fn self_divisible_permutation_count(
        nums: &mut Vec<i32>,
        index: usize,
        set: &mut HashSet<Vec<i32>>,
    ) {
        set.insert(nums.clone());
        for i in index..nums.len() {
            nums.swap(i, index);
            self_divisible_permutation_count(nums, index + 1, set);
            nums.swap(i, index);
        }
    }

    let mut nums: Vec<i32> = vec![];
    for i in 1..=n {
        nums.push(i);
    }
    let mut permutations: HashSet<Vec<i32>> = HashSet::new();
    self_divisible_permutation_count(&mut nums, 0, &mut permutations);
    let mut answer = 0;
    for nums in permutations.into_iter() {
        let mut all_gcd_one = true;
        for j in 1..=nums.len() {
            if gcd(nums[j - 1], j as i32) != 1 {
                all_gcd_one = false;
                break;
            }
        }
        if all_gcd_one {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", self_divisible_permutation_count(1)); // 1
    println!("{}", self_divisible_permutation_count(2)); // 1
    println!("{}", self_divisible_permutation_count(3)); // 3
    println!("{}", self_divisible_permutation_count(4)); // 4
    println!("{}", self_divisible_permutation_count(12)); // 63504
}
