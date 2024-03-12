// https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/description/
pub fn count_submatrices(grid: Vec<Vec<i32>>, k: i32) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        count_submatrices(vec![vec![7, 6, 3], vec![6, 6, 1]], 18)
    ); // 4
    println!(
        "{}",
        count_submatrices(vec![vec![7, 2, 9], vec![1, 5, 0], vec![2, 6, 6]], 20)
    ); // 6
}
