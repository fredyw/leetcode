// https://leetcode.com/problems/count-the-number-of-complete-components/
pub fn count_complete_components(n: i32, edges: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        count_complete_components(6, vec![vec![0, 1], vec![0, 2], vec![1, 2], vec![3, 4]])
    ); // 3
    println!(
        "{}",
        count_complete_components(
            6,
            vec![vec![0, 1], vec![0, 2], vec![1, 2], vec![3, 4], vec![3, 5]]
        )
    ); // 1
    println!(
        "{}",
        count_complete_components(4, vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![3, 0]])
    ); // 0
    println!(
        "{}",
        count_complete_components(4, vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![3, 0]])
    ); // 1
}
