// https://leetcode.com/problems/grid-game/
pub fn grid_game(grid: Vec<Vec<i32>>) -> i64 {
    fn prefix_sums(v: &Vec<i32>) -> Vec<i64> {
        let num_cols = v.len();
        let mut prefix_sums = vec![0i64; num_cols];
        for i in 0..num_cols {
            if i == 0 {
                prefix_sums[i] = v[i] as i64;
            } else {
                prefix_sums[i] = prefix_sums[i - 1] + v[i] as i64;
            }
        }
        return prefix_sums;
    }

    let num_cols = grid[0].len();
    let row0_prefix_sums = prefix_sums(&grid[0]);
    let row1_prefix_sums = prefix_sums(&grid[1]);
    // row0: -xxxxxx
    // row1: |------
    let sum1 = row0_prefix_sums[num_cols - 1] - grid[0][0] as i64;
    // row0: -------
    // row1: xxxxxx|
    let sum2 = row1_prefix_sums[num_cols - 1] - grid[1][num_cols - 1] as i64;
    let mut answer = sum1.min(sum2);
    for i in 1..num_cols - 1 {
        // row0: ---|xxx
        // row1: xxx|---
        let sum3 = row0_prefix_sums[num_cols - 1] - row0_prefix_sums[i];
        let sum4 = row1_prefix_sums[i] - grid[1][i] as i64;
        answer = answer.min(sum3.max(sum4));
    }
    answer
}

fn main() {
    println!("{}", grid_game(vec![vec![2, 5, 4], vec![1, 5, 1]])); // 4
    println!("{}", grid_game(vec![vec![3, 3, 1], vec![8, 5, 2]])); // 4
    println!("{}", grid_game(vec![vec![1, 3, 1, 15], vec![1, 3, 3, 1]])); // 7
    println!(
        "{}",
        grid_game(vec![
            vec![28, 30, 40, 5, 2, 19],
            vec![94, 11, 40, 1, 40, 23]
        ])
    ); // 94
}
