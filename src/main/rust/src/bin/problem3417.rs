// https://leetcode.com/problems/zigzag-grid-traversal-with-skip/description/
pub fn zigzag_traversal(grid: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!("{:?}", zigzag_traversal(vec![vec![1, 2], vec![3, 4]])); // [1,4]
    println!(
        "{:?}",
        zigzag_traversal(vec![vec![2, 1], vec![2, 1], vec![2, 1]])
    ); // [2,1,2]
    println!(
        "{:?}",
        zigzag_traversal(vec![vec![1, 2, 3], vec![4, 5, 6], vec![7, 8, 9]])
    ); // [1,3,5,7,9]
    println!(
        "{:?}",
        zigzag_traversal(vec![
            vec![1, 2, 3, 4],
            vec![5, 6, 7, 8],
            vec![9, 10, 11, 12]
        ])
    ); // [1,3,8,6,9,11]
    println!(
        "{:?}",
        zigzag_traversal(vec![
            vec![1, 2, 3, 4, 5],
            vec![6, 7, 8, 9, 10],
            vec![11, 12, 13, 14, 15]
        ])
    ); // [1,3,5,9,7,11,13,15]
}
