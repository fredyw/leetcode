// https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips-ii/description/
pub fn remove_ones(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        remove_ones(vec![vec![1, 1, 1], vec![1, 1, 1], vec![0, 1, 0]])
    ); // 2
    println!(
        "{}",
        remove_ones(vec![vec![0, 1, 0], vec![1, 0, 1], vec![0, 1, 0]])
    ); // 2
    println!("{}", remove_ones(vec![vec![0, 0], vec![0, 0]])); // 0
}
