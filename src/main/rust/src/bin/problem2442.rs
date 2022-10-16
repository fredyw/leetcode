use std::collections::HashSet;

// https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/
pub fn count_distinct_integers(nums: Vec<i32>) -> i32 {
    let mut set: HashSet<i32> = nums.iter().cloned().collect();
    for num in nums.into_iter() {
        let n: i32 = format!("{}", num)
            .chars()
            .rev()
            .collect::<String>()
            .parse()
            .unwrap();
        set.insert(n);
    }
    set.len() as i32
}

fn main() {
    println!("{}", count_distinct_integers(vec![1, 13, 10, 12, 31])); // 6
    println!("{}", count_distinct_integers(vec![2, 2, 2])); // 1
}
