// https://leetcode.com/problems/sum-of-digits-in-the-minimum-number/description/
pub fn sum_of_digits(nums: Vec<i32>) -> i32 {
    let min = nums.iter().min().unwrap();
    let mut n = *min;
    let mut sum = 0;
    while n > 0 {
        sum += n % 10;
        n /= 10;
    }
    if sum % 2 == 0 {
        1
    } else {
        0
    }
}

fn main() {
    println!("{}", sum_of_digits(vec![34, 23, 1, 24, 75, 33, 54, 8])); // 0
    println!("{}", sum_of_digits(vec![99, 77, 33, 66, 55])); // 1
}
