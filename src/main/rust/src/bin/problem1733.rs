// https://leetcode.com/problems/minimum-number-of-people-to-teach/
pub fn minimum_teachings(n: i32, languages: Vec<Vec<i32>>, friendships: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        minimum_teachings(
            2,
            vec![vec![1], vec![2], vec![1, 2]],
            vec![vec![1, 2], vec![1, 3], vec![2, 3]]
        )
    ); // 1
    println!(
        "{}",
        minimum_teachings(
            3,
            vec![vec![2], vec![1, 3], vec![1, 2], vec![3]],
            vec![vec![1, 4], vec![1, 2], vec![3, 4], vec![2, 3]]
        )
    ); // 2
}
