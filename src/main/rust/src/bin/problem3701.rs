// https://leetcode.com/problems/compute-alternating-sum/description/
pub fn alternating_sum(nums: Vec<i32>) -> i32 {
    let mut even_sum = 0;
    let mut odd_sum = 0;
    for (i, num) in nums.iter().enumerate() {
        if i % 2 == 0 {
            even_sum += num;
        } else {
            odd_sum += num;
        }
    }
    even_sum - odd_sum
}

fn main() {
    println!("{}", alternating_sum(vec![1, 3, 5, 7])); // -4
    println!("{}", alternating_sum(vec![100])); // 100
}
