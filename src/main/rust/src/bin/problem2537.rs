use std::collections::HashMap;

// https://leetcode.com/problems/count-the-number-of-good-subarrays/
pub fn count_good(nums: Vec<i32>, k: i32) -> i64 {
    fn combination(n: i32) -> i32 {
        (n * (n - 1)) / 2
    }

    let mut answer = 0;
    let mut left = 0;
    let mut right = 0;
    let mut map: HashMap<i32, i32> = HashMap::new();
    let mut num_pairs = 0;
    while right < nums.len() {
        *map.entry(nums[right]).or_insert(0) += 1;
        let count = map.get(&nums[right]).unwrap();
        if *count == 2 {
            num_pairs += combination(*count);
        } else if *count > 2 {
            num_pairs -= combination(*count - 1);
            num_pairs += combination(*count);
        }
        while num_pairs >= k {
            answer += nums.len() as i64 - right as i64;
            *map.entry(nums[left]).or_insert(0) -= 1;
            let count = map.get(&nums[left]).unwrap();
            if *count >= 2 {
                num_pairs -= combination(*count + 1);
                num_pairs += combination(*count);
            } else {
                num_pairs -= combination(*count + 1);
            }
            left += 1;
        }
        right += 1;
    }
    answer
}

fn main() {
    println!("{}", count_good(vec![1, 1, 1, 1, 1], 10)); // 1
    println!("{}", count_good(vec![3, 1, 4, 3, 2, 2, 4], 2)); // 4
    println!("{}", count_good(vec![1, 1, 2, 3, 4], 10)); // 0
    println!("{}", count_good(vec![1, 2, 2, 2], 10)); // 0
    println!("{}", count_good(vec![1, 2, 2, 2], 3)); // 2
    println!(
        "{}",
        count_good(
            vec![3, 1, 4, 3, 2, 2, 4, 9, 34, 1, 456, 23, 12, 7, 8, 734, 33, 4, 2, 456, 23],
            2
        )
    ); // 63
}
