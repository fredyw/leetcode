use std::collections::HashMap;

// https://leetcode.com/problems/count-nice-pairs-in-an-array/description/
pub fn count_nice_pairs(nums: Vec<i32>) -> i32 {
    fn reverse(mut n: i32) -> i32 {
        let mut reversed = 0;
        while n > 0 {
            let m = n % 10;
            reversed = reversed * 10 + m;
            n /= 10;
        }
        reversed
    }

    // nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
    // nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
    let mut map: HashMap<i32, i64> = HashMap::new();
    for &num in nums.iter() {
        *map.entry(num - reverse(num)).or_insert(0) += 1;
    }
    let mut answer: i64 = 0;
    for &num in nums.iter() {
        let count = map.get(&(num - reverse(num))).unwrap() - 1;
        answer += count;
    }
    ((answer / 2) % 1_000_000_007) as i32
}

fn main() {
    println!("{:?}", count_nice_pairs(vec![42, 11, 1, 97])); // 2
    println!("{:?}", count_nice_pairs(vec![13, 10, 35, 24, 76])); // 4
}
