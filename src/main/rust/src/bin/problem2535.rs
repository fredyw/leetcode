// https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/
pub fn difference_of_sum(nums: Vec<i32>) -> i32 {
    let element_sum: i32 = nums.iter().sum();
    let digit_sum: i32 = nums
        .iter()
        .flat_map(|a| {
            let s = format!("{}", a);
            let c: Vec<i32> = s
                .as_bytes()
                .iter()
                .map(|b| (*b - '0' as u8) as i32)
                .collect();
            c
        })
        .sum();
    (element_sum - digit_sum).abs()
}

fn main() {
    println!("{}", difference_of_sum(vec![1, 15, 6, 3])); // 9
    println!("{}", difference_of_sum(vec![1, 2, 3, 4])); // 0
}
