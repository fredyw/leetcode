// https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/description/
pub fn count_submatrices(grid: Vec<Vec<i32>>, k: i32) -> i32 {
    let mut answer = 0;
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    let mut prefix_sums: Vec<Vec<i32>> = vec![vec![0; num_cols]; num_rows];
    for row in 0..num_rows {
        let mut col_sum = 0;
        for col in 0..num_cols {
            col_sum += grid[row][col];
            let prefix_sum = if row > 0 {
                prefix_sums[row - 1][col]
            } else {
                0
            };
            let sum = col_sum + prefix_sum;
            if sum <= k {
                answer += 1;
            }
            prefix_sums[row][col] = sum;
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        count_submatrices(vec![vec![7, 6, 3], vec![6, 6, 1]], 18)
    ); // 4
    println!(
        "{}",
        count_submatrices(vec![vec![7, 2, 9], vec![1, 5, 0], vec![2, 6, 6]], 20)
    ); // 6
}
