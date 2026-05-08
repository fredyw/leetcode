// https://leetcode.com/problems/closest-equal-element-queries/description/
pub fn solve_queries(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        solve_queries(vec![1, 3, 1, 4, 1, 3, 2], vec![0, 3, 5])
    ); // [2,-1,3]
    println!("{:?}", solve_queries(vec![1, 2, 3, 4], vec![0, 1, 2, 3])); // [-1,-1,-1,-1]
}
