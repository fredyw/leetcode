use std::collections::HashSet;

// https://leetcode.com/problems/number-of-distinct-averages/
pub fn distinct_averages(mut nums: Vec<i32>) -> i32 {
    nums.sort();
    let mut set: HashSet<String> = HashSet::new();
    let mut i = 0;
    let mut j = nums.len() - 1;
    while i < j {
        let average = (nums[i] + nums[j]) as f32 / 2 as f32;
        set.insert(format!("{}", average));
        i += 1;
        j -= 1;
    }
    set.len() as i32
}

fn main() {
    println!("{}", distinct_averages(vec![4, 1, 4, 0, 3, 5])); // 2
    println!("{}", distinct_averages(vec![1, 100])); // 1
}
