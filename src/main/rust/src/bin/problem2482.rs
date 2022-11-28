// https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
pub fn ones_minus_zeros(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        ones_minus_zeros(vec![vec![0, 1, 1], vec![1, 0, 1], vec![0, 0, 1]])
    ); // [[0,0,4],[0,0,4],[-2,-2,2]]
    println!("{:?}", ones_minus_zeros(vec![vec![1, 1, 1], vec![1, 1, 1]])); // [[5,5,5],[5,5,5]]
}
