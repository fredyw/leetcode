use std::collections::HashSet;

// https://leetcode.com/problems/determine-the-minimum-sum-of-a-k-avoiding-array/
pub fn minimum_sum(n: i32, k: i32) -> i32 {
    let mut answer = 0;
    let mut count = 0;
    let mut set: HashSet<i32> = HashSet::new();
    let mut i = 1;
    while count < n {
        if set.contains(&i) {
            i += 1;
            continue;
        }
        if k - i > 0 {
            set.insert(k - i);
        }
        answer += i;
        i += 1;
        count += 1;
    }
    answer
}

fn main() {
    println!("{}", minimum_sum(5, 4)); // 18
    println!("{}", minimum_sum(2, 6)); // 3
    println!("{}", minimum_sum(3, 3)); // 8
    println!("{}", minimum_sum(10, 6)); // 69
}
