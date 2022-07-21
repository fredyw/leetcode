// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
pub fn num_submatrix_sum_target(matrix: Vec<Vec<i32>>, target: i32) -> i32 {
    let mut answer = 0;
    let max_rows = matrix.len();
    let max_cols = if max_rows > 0 { matrix[0].len() } else { 0 };
    let mut prefix_sums = vec![vec![0; max_cols]; max_rows];
    for row in 0..max_rows {
        for col in 0..max_cols {
            prefix_sums[row][col] = if col == 0 {
                matrix[row][col]
            } else {
                prefix_sums[row][col - 1] + matrix[row][col]
            };
        }
    }
    for row1 in 0..max_rows {
        for col1 in 0..max_cols {
            for row2 in row1..max_rows {
                for col2 in col1..max_cols {
                    let mut sum = 0;
                    for i in row1..=row2 {
                        sum += if col1 == 0 {
                            prefix_sums[i][col2]
                        } else {
                            prefix_sums[i][col2] - prefix_sums[i][col1 - 1]
                        };
                    }
                    if sum == target {
                        answer += 1;
                    }
                }
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        num_submatrix_sum_target(vec![vec![0, 0, 0], vec![1, -1, 1], vec![0, 1, 0]], 0)
    ); // 14
    println!(
        "{}",
        num_submatrix_sum_target(vec![vec![0, 1, 0], vec![1, 1, 1], vec![0, 1, 0]], 0)
    ); // 4
    println!(
        "{}",
        num_submatrix_sum_target(vec![vec![1, -1], vec![-1, 1]], 0)
    ); // 5
    println!("{}", num_submatrix_sum_target(vec![vec![904]], 0)); // 0
    println!(
        "{}",
        num_submatrix_sum_target(
            vec![
                vec![0, 0, 0, 1, 1],
                vec![1, 1, 1, 0, 1],
                vec![1, 1, 1, 1, 0],
                vec![0, 0, 0, 1, 0],
                vec![0, 0, 0, 1, 1]
            ],
            0
        )
    ); // 28
}
