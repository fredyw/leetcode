// https://leetcode.com/problems/maximum-earnings-from-taxi/
pub fn max_taxi_earnings(n: i32, rides: Vec<Vec<i32>>) -> i64 {
    todo!()
}

fn main() {
    println!(
        "{}",
        max_taxi_earnings(5, vec![vec![2, 5, 4], vec![1, 5, 1]])
    ); // 7
    println!(
        "{}",
        max_taxi_earnings(
            20,
            vec![
                vec![1, 6, 1],
                vec![3, 10, 2],
                vec![10, 12, 3],
                vec![11, 12, 2],
                vec![12, 15, 2],
                vec![13, 18, 1]
            ]
        )
    ); // 20
}
