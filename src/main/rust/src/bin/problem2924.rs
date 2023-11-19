// https://leetcode.com/problems/find-champion-ii/description/
pub fn find_champion(n: i32, edges: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", find_champion(3, vec![vec![0, 1], vec![1, 2]])); // 0
    println!(
        "{}",
        find_champion(4, vec![vec![0, 2], vec![1, 3], vec![1, 2]])
    ); // -1
    println!(
        "{}",
        find_champion(3, vec![vec![0, 1], vec![1, 2], vec![0, 2]])
    ); // 0
}
