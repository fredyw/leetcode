// https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/
pub fn hardest_worker(n: i32, logs: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        hardest_worker(10, vec![vec![0, 3], vec![2, 5], vec![0, 9], vec![1, 15]])
    ); // 1
    println!(
        "{}",
        hardest_worker(26, vec![vec![1, 1], vec![3, 7], vec![2, 12], vec![7, 17]])
    ); // 3
    println!("{}", hardest_worker(2, vec![vec![0, 10], vec![1, 20]])); // 0
}
