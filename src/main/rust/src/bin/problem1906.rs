// https://leetcode.com/problems/minimum-absolute-difference-queries/
pub fn min_difference(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        min_difference(
            vec![1, 3, 4, 8],
            vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![0, 3]]
        )
    ); // [2,1,4,1]
    println!(
        "{:?}",
        min_difference(
            vec![4, 5, 2, 2, 7, 10],
            vec![vec![2, 3], vec![0, 2], vec![0, 5], vec![3, 5]]
        )
    ); // [-1,1,1,3]
    println!("{:?}", min_difference(vec![1, 3, 3, 1], vec![vec![0, 3]])); // [2]
    println!("{:?}", min_difference(vec![3, 3, 3, 1], vec![vec![0, 3]])); // [2]
    println!("{:?}", min_difference(vec![3, 3, 3, 3], vec![vec![0, 3]])); // [-1]
}
