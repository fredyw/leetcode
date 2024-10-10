// https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/description/
pub fn max_good_number(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() {
        for j in 0..nums.len() {
            if i == j {
                continue;
            }
            for k in 0..nums.len() {
                if i == k || j == k {
                    continue;
                }
                let binary = format!("{:b}{:b}{:b}", nums[i], nums[j], nums[k]);
                let n = i32::from_str_radix(&binary, 2).unwrap();
                answer = answer.max(n);
            }
        }
    }
    answer
}

fn main() {
    println!("{}", max_good_number(vec![1, 2, 3])); // 30
    println!("{}", max_good_number(vec![2, 8, 16])); // 1296
}
