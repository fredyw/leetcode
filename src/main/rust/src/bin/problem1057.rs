// https://leetcode.com/problems/campus-bikes/description/
pub fn assign_bikes(workers: Vec<Vec<i32>>, bikes: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        assign_bikes(vec![vec![0, 0], vec![2, 1]], vec![vec![1, 2], vec![3, 3]])
    ); // [1,0]
    println!(
        "{:?}",
        assign_bikes(
            vec![vec![0, 0], vec![1, 1], vec![2, 0]],
            vec![vec![1, 0], vec![2, 2], vec![2, 1]]
        )
    ); // [0,2,1]
}
