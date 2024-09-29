// https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/description/
pub fn min_element(nums: Vec<i32>) -> i32 {
    fn sum(mut n: i32) -> i32 {
        let mut sum = 0;
        while n > 0 {
            sum += n % 10;
            n /= 10;
        }
        sum
    }

    nums.into_iter().map(|n| sum(n)).min().unwrap()
}

fn main() {
    println!("{}", min_element(vec![10, 12, 13, 14])); // 1
    println!("{}", min_element(vec![1, 2, 3, 4])); // 1
    println!("{}", min_element(vec![999, 19, 199])); // 10
}
