// https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/description/
pub fn minimum_average(mut nums: Vec<i32>) -> f64 {
    let mut answer = f64::MAX;
    nums.sort();
    let mut i = 0;
    let mut j = nums.len() - 1;
    while i < j {
        answer = answer.min((nums[i] as f64 + nums[j] as f64) / 2.0);
        i += 1;
        j -= 1;
    }
    answer
}

fn main() {
    println!("{}", minimum_average(vec![7, 8, 3, 4, 15, 13, 4, 1])); // 5.5
    println!("{}", minimum_average(vec![1, 9, 8, 3, 10, 5])); // 5.5
    println!("{}", minimum_average(vec![1, 2, 3, 7, 8, 9])); // 5.0
}
