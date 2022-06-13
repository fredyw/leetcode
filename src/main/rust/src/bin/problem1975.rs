pub fn max_matrix_sum(matrix: Vec<Vec<i32>>) -> i64 {
    todo!()
}

fn main() {
    println!("{}", max_matrix_sum(vec![vec![1, -1], vec![-1, 1]])); // 4
    println!(
        "{}",
        max_matrix_sum(vec![vec![1, 2, 3], vec![-1, -2, -3], vec![1, 2, 3]])
    ); // 16
    println!(
        "{}",
        max_matrix_sum(vec![
            vec![1, 2, 3, 4],
            vec![-1, -2, -3, 4],
            vec![1, 2, 3, 4],
            vec![1, 2, 3, 4]
        ])
    ); // 38
    println!(
        "{}",
        max_matrix_sum(vec![
            vec![1, 2, 3, 4],
            vec![-1, -2, -3, -4],
            vec![1, 2, 3, 4],
            vec![1, 2, 3, 4]
        ])
    ); // 40
    println!(
        "{}",
        max_matrix_sum(vec![
            vec![1, 2, 3, 4, 5],
            vec![1, 2, 3, 4, 5],
            vec![1, 2, -3, 4, 5],
            vec![1, 2, 3, 4, 5],
            vec![1, 2, 3, 4, 5],
        ])
    ); // 73
}
