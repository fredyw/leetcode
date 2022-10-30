// https://leetcode.com/problems/grid-game/
pub fn grid_game(mut grid: Vec<Vec<i32>>) -> i64 {
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

    let row1_prefix_sums = prefix_sums(&grid[0]);
    let row2_prefix_sums = prefix_sums(&grid[1]);
    let mut max = 0;
    let mut max_index = 0;
    let mut is_right = true;
    let num_cols = grid[0].len();
    for i in 0..num_cols {
        let right_sum = row1_prefix_sums[num_cols - 1] + grid[1][num_cols - 1] as i64;
        let down_sum = row1_prefix_sums[i]
            + (row2_prefix_sums[num_cols - 1] - if i == 0 { 0 } else { row2_prefix_sums[i - 1] });
        if max < right_sum {
            max = right_sum;
            max_index = i;
            is_right = true;
        }
        if max < down_sum {
            max = down_sum;
            max_index = i;
            is_right = false;
        }
    }
    if is_right {
        for i in 0..num_cols {
            grid[0][i] = 0;
            grid[1][num_cols - 1] = 0;
        }
    } else {
        for i in 0..=max_index {
            grid[0][i] = 0;
        }
        for i in max_index..num_cols {
            grid[1][i] = 0;
        }
    }
    let row1_prefix_sums = prefix_sums(&grid[0]);
    let row2_prefix_sums = prefix_sums(&grid[1]);
    let mut answer = 0;
    let num_cols = grid[0].len();
    for i in 0..num_cols {
        let right_sum = row1_prefix_sums[num_cols - 1] + grid[1][num_cols - 1] as i64;
        let down_sum = row1_prefix_sums[i]
            + (row2_prefix_sums[num_cols - 1] - if i == 0 { 0 } else { row2_prefix_sums[i - 1] });
        answer = answer.max(right_sum.max(down_sum));
    }
    answer
}

fn main() {
    // println!("{}", grid_game(vec![vec![2, 5, 4], vec![1, 5, 1]])); // 4
    // println!("{}", grid_game(vec![vec![3, 3, 1], vec![8, 5, 2]])); // 4
    // println!("{}", grid_game(vec![vec![1, 3, 1, 15], vec![1, 3, 3, 1]])); // 7
    println!(
        "{}",
        grid_game(vec![
            vec![28, 30, 40, 5, 2, 19],
            vec![94, 11, 40, 1, 40, 23]
        ])
    ); // 94
}
