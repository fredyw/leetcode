// https://leetcode.com/problems/sum-of-remoteness-of-all-cells/description/
pub fn sum_remoteness(grid: Vec<Vec<i32>>) -> i64 {
    todo!()
}

fn main() {
    println!(
        "{}",
        sum_remoteness(vec![vec![-1, 1, -1], vec![5, -1, 4], vec![-1, 3, -1]])
    ); // 39
    println!(
        "{}",
        sum_remoteness(vec![vec![-1, 3, 4], vec![-1, -1, -1], vec![3, -1, -1]])
    ); // 13
    println!("{}", sum_remoteness(vec![vec![1]])); // 0
}
