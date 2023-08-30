use std::collections::HashSet;

// https://leetcode.com/problems/find-the-minimum-possible-sum-of-a-beautiful-array/
pub fn minimum_possible_sum(n: i32, target: i32) -> i64 {
    let mut answer = 0;
    let mut n = n;
    let target = target as i64;
    let mut ignore: HashSet<i64> = HashSet::new();
    let mut i: i64 = 1;
    loop {
        if n == 0 {
            break;
        }
        if ignore.contains(&i) {
            i += 1;
            continue;
        }
        if target - i > 0 {
            ignore.insert(target - i);
        }
        answer += i;
        n -= 1;
        i += 1;
    }
    answer
}

fn main() {
    println!("{}", minimum_possible_sum(2, 3)); // 4
    println!("{}", minimum_possible_sum(3, 3)); // 8
    println!("{}", minimum_possible_sum(1, 1)); // 1
    println!("{}", minimum_possible_sum(4, 4)); // 12
}
