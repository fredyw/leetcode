// https://leetcode.com/problems/xor-after-range-multiplication-queries-i/description/
pub fn xor_after_queries(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        xor_after_queries(vec![1, 1, 1], vec![vec![0, 2, 1, 4]])
    ); // 4
    println!(
        "{}",
        xor_after_queries(
            vec![2, 3, 1, 5, 4],
            vec![vec![1, 4, 2, 3], vec![0, 2, 1, 2]]
        )
    ); // 31
}
