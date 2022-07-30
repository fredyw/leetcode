// https://leetcode.com/problems/number-of-ways-to-split-array/
pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
    let mut prefix_sums: Vec<i64> = vec![0; nums.len()];
    for (i, num) in nums.iter().enumerate() {
        prefix_sums[i] = if i == 0 {
            *num as i64
        } else {
            prefix_sums[i - 1] + *num as i64
        };
    }
    let mut answer = 0;
    for i in 0..(nums.len() - 1) {
        let left = prefix_sums[i];
        let right = prefix_sums[nums.len() - 1] - prefix_sums[i];
        if left >= right {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", ways_to_split_array(vec![10, 4, -8, 7])); // 2
    println!("{}", ways_to_split_array(vec![2, 3, 1, 0])); // 2
}
