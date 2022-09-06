// https://leetcode.com/problems/maximum-rows-covered-by-columns/
pub fn maximum_rows(mat: Vec<Vec<i32>>, cols: i32) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        maximum_rows(
            vec![vec![0, 0, 0], vec![1, 0, 1], vec![0, 1, 1], vec![0, 0, 1]],
            2
        )
    ); // 3
    println!(
        "{}",
        maximum_rows(
            vec![
                vec![0, 0, 0],
                vec![1, 0, 1],
                vec![0, 1, 1],
                vec![0, 0, 1],
                vec![1, 1, 1]
            ],
            2
        )
    ); // 3
    println!(
        "{}",
        maximum_rows(
            vec![
                vec![0, 0, 0],
                vec![1, 0, 1],
                vec![0, 1, 1],
                vec![0, 0, 1],
                vec![1, 1, 1]
            ],
            3
        )
    ); // 5
    println!("{}", maximum_rows(vec![vec![1], vec![0]], 1)); // 2
}
