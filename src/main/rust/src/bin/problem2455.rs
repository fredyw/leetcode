// https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/
pub fn average_value(nums: Vec<i32>) -> i32 {
    let mut sum = 0;
    let mut count = 0;
    for num in nums.into_iter() {
        if num % 2 == 0 && num % 3 == 0 {
            sum += num;
            count += 1;
        }
    }
    if count == 0 {
        0
    } else {
        sum / count
    }
}

fn main() {
    println!("{}", average_value(vec![1, 3, 6, 10, 12, 15])); // 9
    println!("{}", average_value(vec![1, 2, 4, 7, 10])); // 0
}
