// https://leetcode.com/problems/path-existence-queries-in-a-graph-i/description/
pub fn path_existence_queries(
    n: i32,
    nums: Vec<i32>,
    max_diff: i32,
    queries: Vec<Vec<i32>>,
) -> Vec<bool> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        path_existence_queries(2, vec![1, 3], 1, vec![vec![0, 0], vec![0, 1]])
    ); // [true,false]
    println!(
        "{:?}",
        path_existence_queries(
            4,
            vec![2, 5, 6, 8],
            2,
            vec![vec![0, 1], vec![0, 2], vec![1, 3], vec![2, 3]]
        )
    ); // [false,false,true,true]
}
