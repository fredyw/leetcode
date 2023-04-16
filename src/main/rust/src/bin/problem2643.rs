// https://leetcode.com/problems/row-with-maximum-ones/
pub fn row_and_maximum_ones(mat: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!("{:?}", row_and_maximum_ones(vec![vec![0, 1], vec![1, 0]])); // [0,1]
    println!(
        "{:?}",
        row_and_maximum_ones(vec![vec![0, 0, 0], vec![0, 1, 1]])
    ); // [1,2]
    println!(
        "{:?}",
        row_and_maximum_ones(vec![vec![0, 0], vec![1, 1], vec![0, 0]])
    ); // [1,2]
}
