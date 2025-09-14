// https://leetcode.com/problems/smallest-absent-positive-greater-than-average/description/
pub fn smallest_absent(mut nums: Vec<i32>) -> i32 {
    nums.sort_unstable();
    let avg = (nums.iter().sum::<i32>() as f32 / nums.len() as f32).ceil() as i32;
    println!("avg: {avg}");
    let mut answer = 0;
    let mut i = 0;
    while i < nums.len() && avg >= nums[i] {
        i += 1;
    }
    answer
}

fn main() {
    println!("{}", smallest_absent(vec![3, 5])); // 6
    println!("{}", smallest_absent(vec![-1, 1, 2])); // 3
    println!("{}", smallest_absent(vec![4, -1])); // 2
}
