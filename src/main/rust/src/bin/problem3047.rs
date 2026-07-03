// https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/description/
pub fn largest_square_area(bottom_left: Vec<Vec<i32>>, top_right: Vec<Vec<i32>>) -> i64 {
    todo!()
}

fn main() {
    println!(
        "{}",
        largest_square_area(
            vec![vec![1, 1], vec![2, 2], vec![3, 1]],
            vec![vec![3, 3], vec![4, 4], vec![6, 6]]
        )
    ); // 1
    println!(
        "{}",
        largest_square_area(
            vec![vec![1, 1], vec![1, 3], vec![1, 5]],
            vec![vec![5, 5], vec![5, 7], vec![5, 9]]
        )
    ); // 4
    println!(
        "{}",
        largest_square_area(
            vec![vec![1, 1], vec![2, 2], vec![1, 2]],
            vec![vec![3, 3], vec![4, 4], vec![3, 4]]
        )
    ); // 1
    println!(
        "{}",
        largest_square_area(
            vec![vec![1, 1], vec![3, 3], vec![3, 1]],
            vec![vec![2, 2], vec![4, 4], vec![4, 2]]
        )
    ); // 0
}
