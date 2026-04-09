// https://leetcode.com/problems/maximum-requests-without-violating-the-limit/description/
pub fn max_requests(requests: Vec<Vec<i32>>, k: i32, window: i32) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        max_requests(vec![vec![1, 1], vec![2, 1], vec![1, 7], vec![2, 8]], 1, 4)
    ); // 4
    println!(
        "{}",
        max_requests(vec![vec![1, 2], vec![1, 5], vec![1, 2], vec![1, 6]], 2, 5)
    ); // 4
    println!(
        "{}",
        max_requests(vec![vec![1, 1], vec![2, 5], vec![1, 2], vec![3, 9]], 1, 1)
    ); // 4
    println!(
        "{}",
        max_requests(
            vec![vec![1, 1], vec![1, 3], vec![1, 5], vec![1, 7], vec![1, 9]],
            2,
            3
        )
    ); // 7
    println!(
        "{}",
        max_requests(
            vec![vec![1, 1], vec![1, 2], vec![1, 3], vec![1, 4], vec![1, 5]],
            2,
            2
        )
    ); // 4
}
