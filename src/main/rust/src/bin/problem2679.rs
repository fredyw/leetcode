// https://leetcode.com/problems/sum-in-a-matrix/
pub fn matrix_sum(mut nums: Vec<Vec<i32>>) -> i32 {
    for i in 0..nums.len() {
        nums[i].sort();
    }
    let mut answer = 0;
    let max_row = nums.len();
    let max_col = if max_row > 0 { nums[0].len() } else { 0 };
    for col in 0..max_col {
        let mut max = 0;
        for row in 0..max_row {
            max = max.max(nums[row][col]);
        }
        answer += max;
    }
    answer
}

fn main() {
    println!(
        "{}",
        matrix_sum(vec![
            vec![7, 2, 1],
            vec![6, 4, 2],
            vec![6, 5, 3],
            vec![3, 2, 1]
        ])
    ); // 15
    println!("{}", matrix_sum(vec![vec![1]])); // 1
}
