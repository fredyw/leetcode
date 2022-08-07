use std::collections::HashSet;

// https://leetcode.com/problems/number-of-arithmetic-triplets/
pub fn arithmetic_triplets(nums: Vec<i32>, diff: i32) -> i32 {
    let mut set: HashSet<i32> = HashSet::new();
    for num in nums.iter() {
        set.insert(*num);
    }
    let mut answer = 0;
    for num in nums.into_iter() {
        let a = num + diff;
        let b = a + diff;
        if set.get(&a).is_some() && set.get(&b).is_some() {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", arithmetic_triplets(vec![0, 1, 4, 6, 7, 10], 3)); // 2
    println!("{}", arithmetic_triplets(vec![4, 5, 6, 7, 8, 9], 2)); // 2
}
