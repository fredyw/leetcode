// https://leetcode.com/problems/minimum-value-of-merged-integers/description/
pub fn min_merged_integer(nums: Vec<i32>) -> i32 {
    let mut answer = i32::MAX;
    let mut i = 0;
    while i < nums.len() - 1 {
        let n = format!("{}{}", nums[i], nums[i + 1])
            .parse::<i32>()
            .unwrap();
        answer = answer.min(n);
        i += 2;
    }
    answer
}

fn main() {
    println!("{}", min_merged_integer(vec![23, 55, 42, 21])); // 2355
    println!("{}", min_merged_integer(vec![34, 7, 11, 11])); // 347
    println!("{}", min_merged_integer(vec![9, 20])); // 920
}
