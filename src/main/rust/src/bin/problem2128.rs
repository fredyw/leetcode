// https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/description/
pub fn remove_ones(grid: Vec<Vec<i32>>) -> bool {
    todo!()
}

fn main() {
    println!(
        "{}",
        remove_ones(vec![vec![0, 1, 0], vec![1, 0, 1], vec![0, 1, 0]])
    ); // true
    println!(
        "{}",
        remove_ones(vec![vec![1, 1, 0], vec![0, 0, 0], vec![0, 0, 0]])
    ); // false
    println!("{}", remove_ones(vec![vec![0]])); // true
}
