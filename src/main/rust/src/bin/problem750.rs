// https://leetcode.com/problems/number-of-corner-rectangles/description/
pub fn count_corner_rectangles(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        count_corner_rectangles(vec![
            vec![1, 0, 0, 1, 0],
            vec![0, 0, 1, 0, 1],
            vec![0, 0, 0, 1, 0],
            vec![1, 0, 1, 0, 1]
        ])
    ); // 1
    println!(
        "{}",
        count_corner_rectangles(vec![vec![1, 1, 1], vec![1, 1, 1], vec![1, 1, 1]])
    ); // 9
    println!("{}", count_corner_rectangles(vec![vec![1, 1, 1, 1]])); // 0
}
