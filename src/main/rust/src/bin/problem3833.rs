// https://leetcode.com/problems/count-dominant-indices/description/
pub fn dominant_indices(nums: Vec<i32>) -> i32 {
    let mut averages: Vec<f64> = vec![0.0; nums.len()];
    let mut i = nums.len() as isize - 1;
    let mut sum = 0;
    while i >= 0 {
        sum += nums[i as usize];
        averages[i as usize] = sum as f64 / (nums.len() - i as usize) as f64;
        i -= 1;
    }
    let mut answer = 0;
    for i in 0..nums.len() - 1 {
        if nums[i] as f64 > averages[i + 1] {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", dominant_indices(vec![5, 4, 3])); // 2
    println!("{}", dominant_indices(vec![4, 1, 2])); // 1
}
