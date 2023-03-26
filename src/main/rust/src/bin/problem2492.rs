// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
pub fn min_score(n: i32, roads: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        min_score(
            4,
            vec![vec![1, 2, 9], vec![2, 3, 6], vec![2, 4, 5], vec![1, 4, 7]]
        )
    ); // 5
    println!(
        "{}",
        min_score(4, vec![vec![1, 2, 2], vec![1, 3, 4], vec![3, 4, 7]])
    ); // 5
}
