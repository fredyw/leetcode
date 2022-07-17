use std::collections::HashMap;

// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
pub fn maximum_sum(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, (i32, i32)> = HashMap::new();
    for num in nums {
        let sum: i32 = num.to_string().chars().map(|a| a as i32 - '0' as i32).sum();
        if !map.contains_key(&sum) {
            map.insert(sum, (num, 0));
        } else {
            let value = map.get_mut(&sum).unwrap();
            if num > value.0 {
                value.1 = value.0;
                value.0 = num;
            } else if num > value.1 {
                value.1 = num;
            }
        }
    }
    let mut answer = -1;
    for (_, pair) in map {
        if pair.0 > 0 && pair.1 > 0 {
            answer = answer.max(pair.0 + pair.1);
        }
    }
    answer
}

fn main() {
    println!("{}", maximum_sum(vec![18, 43, 36, 13, 7])); // 54
    println!("{}", maximum_sum(vec![10, 12, 19, 14])); // -1
}
